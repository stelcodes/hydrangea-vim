(ns colorscheme-builder
  (:require [clojure.string :as str]))

;; Syntax Highlighting Functions

(defn syntax-style->vs [[syntax-group style]]
  (cond
   ;; If keyword, this is a syntax group linking to another one
   (keyword? style)
   (str "hi link " (symbol syntax-group) " " (symbol style))

   ;; If map, this is a standard definition with colors and decoration
   (map? style)
   (let [{:keys [fg bg deco]} style]
     (->> ["hi"
           (symbol syntax-group)
           (cond (map? fg) (str "guifg=" (:gui fg) " ctermfg=" (:cterm fg))
                 (string? fg) (str "guifg=" fg " ctermfg=" fg)
                 :else nil)
           (cond (map? bg) (str "guibg=" (:gui bg) " ctermbg=" (:cterm bg))
                 (string? bg) (str "guibg=" bg " ctermbg=" bg)
                 :else nil)
           (when deco (str "gui=" deco " cterm=" deco))]
          ;; filter identity idiom removes falsey values from collection
          (filter identity)
          (str/join " ")))))

(comment (syntax-style->vs [:Comment {:fg magenta01 :deco none}]))

;; Terminal Color Functions
(defn terminal-style->vs [index color]
  (str "let g:terminal_color_" index "  = '" (:gui color) "'"))

;; Lightline Functions
(defn keyword->vs [k]
  (str "'" (symbol k) "':"))

(defn ll-text-styles->vs [{:keys [fg bg]}]
  (str "[\"" (:gui fg) "\",\"" (:gui bg) "\"],"))

(defn ll-position-styles->vs [[position text-styles]]
  (str "\\   " (keyword->vs position) "[" (str/join (map ll-text-styles->vs text-styles)) "],"))

(defn ll-mode-styles->vs [[mode position-styles]]
  (str/join
   "\n"
   (flatten
    [(str "\\ " (keyword->vs mode) "{")
     (map ll-position-styles->vs position-styles)
     "\\ },"])))

;; Generate vimscript

(defn build-main [syntax-styles terminal-styles]
  (str/join
   "\n"
   (flatten
    ["hi clear"
     "if exists('syntax_on')"
     "  syntax reset"
     "endif"
     "let g:colors_name = 'hydrangea'"
     "set background=dark"
     ""
     "\" Styles"
     "\" =========="
     (map syntax-style->vs (partition 2 syntax-styles))
     ""
     (if terminal-styles
       ["\" Terminal Colors"
        "\" ==========="
        (map-indexed terminal-style->vs terminal-styles)])])))

(defn build-lightline [lightline-styles]
  (when lightline-styles
    (str/join
     "\n"
     (flatten
      ["let s:config={"
       (map ll-mode-styles->vs lightline-styles)
       "\\}"
       "let g:lightline#colorscheme#hydrangea#palette = lightline#colorscheme#fill(s:config)"]))))

;; Write vimscript to files
(defn build [syntax-styles terminal-styles lightline-styles]
  (let [main-colorscheme-vs (build-main syntax-styles terminal-styles)
        main-colorscheme-path "colors/hydrangea.vim"]
    (spit main-colorscheme-path main-colorscheme-vs)
    (println main-colorscheme-vs)
    (println (str "Wrote to file: " main-colorscheme-path))
    (if lightline-styles
      (let [lightline-colorscheme-vs (build-lightline lightline-styles)
            lightline-colorscheme-path "autoload/lightline/colorscheme/hydrangea.vim"]
        (spit lightline-colorscheme-path lightline-colorscheme-vs)
        (println lightline-colorscheme-vs)
        (println (str "Wrote to file: " lightline-colorscheme-path)))
      (println "Skipping lightline colorscheme..."))))
