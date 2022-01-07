#!/usr/bin/env bb

(require '[clojure.string :as str])

; Palette
(def base03    {:gui "#1e222c" :cterm 235}) ; L* = 44
(def base02    {:gui "#2a303b" :cterm 236}) ; L* = 50
(def base01    {:gui "#3b4351" :cterm 238}) ; L* = 58
(def base00    {:gui "#586374" :cterm 241}) ; L* = 68
(def base2     {:gui "#c3d5ec" :cterm 252}) ; L* = 93
(def base3     {:gui "#edf5ff" :cterm 255}) ; L* = 99
(def red01     {:gui "#681c36" :cterm 52})
(def red1      {:gui "#e91e63" :cterm 161})
(def teal01    {:gui "#134242" :cterm 23})
(def teal2     {:gui "#36c2c2" :cterm 44})
(def cyan01    {:gui "#064253" :cterm 23})
(def cyan1     {:gui "#169ec4" :cterm 38})
(def cyan2     {:gui "#56c7ee" :cterm 81})
(def cyan3     {:gui "#bcebfe" :cterm 153})
(def blue1     {:gui "#537dd5" :cterm 68})
(def blue2     {:gui "#8baafe" :cterm 111})
(def blue3     {:gui "#c9d4fd" :cterm 189})
(def violet1   {:gui "#996ddb" :cterm 98})
(def violet2   {:gui "#c398fe" :cterm 183})
(def violet3   {:gui "#e2ccfe" :cterm 225})
(def magenta01 {:gui "#68024b" :cterm 89})
(def magenta1  {:gui "#e242ac" :cterm 162})
(def magenta2  {:gui "#fe7ecd" :cterm 213})
(def magenta3  {:gui "#ffc3e4" :cterm 218})
(def bold      "bold")
(def underline "underline")
(def undercurl "undercurl")
(def none      "NONE")
(def fg        "fg")
(def bg        "bg")

(def syntax-styles
 {:Normal          {:fg base2 :bg base03}
  :Cursor          {:fg none :bg base3 :deco none}
  :CursorIM        {:fg none :bg base3}
  :CursorLine      {:fg none :bg base02 :deco bold}
  :CursorColumn    {:fg none :bg base02 :deco none}
  :Visual          {:fg none :bg base01 :deco none}
  :VisualNOS       {:fg fg :deco underline}

  :Folded          {:fg base2 :bg base02 :deco none}
  :FoldColumn      {:fg base2 :bg base03 :deco none}
  :Title           {:fg magenta1 :bg none :deco bold}
  :StatusLine      {:fg base2 :bg base01 :deco none}
  :StatusLineNC    {:fg base00 :bg base02 :deco none}
  :VertSplit       {:fg base02 :bg base02 :deco none}
  :LineNr          {:fg base00 :bg base02 :deco none}
  :CursorLineNr    {:fg base3 :bg base00 :deco bold}
  :SpecialKey      {:fg cyan01 :bg cyan1 :deco bold}
  :NonText         {:fg base00 :bg base03 :deco none}
  :MatchParen      {:fg red1 :bg none :deco bold}

  :Comment         {:fg base00 :deco none}
  :Constant        {:fg teal2 :bg teal01 :deco none}
  :String          :Constant
  :Number          {:fg cyan2 :bg cyan01 :deco none}
  :Identifier      {:fg base3 :deco bold}
  :Function        {:fg base3 :deco bold}
  :Statement       {:fg blue1 :deco bold}
  :Operator        {:fg magenta1 :deco none}
  :Include         {:fg violet1 :deco none}
  :PreProc         {:fg violet2 :deco none}
  :Type            {:fg magenta1 :deco none}
  :StorageClass    {:fg blue1 :deco bold}
  :Structure       {:fg magenta1 :deco none}
  :Typedef         {:fg blue1 :deco bold}
  :Special         {:fg blue2 :bg none :deco bold}
  :Underlined      {:fg fg :deco underline}
  :Ignore          {:fg bg}
  :Error           {:fg red1 :bg red01 :deco bold}
  :Todo            {:fg base2 :bg base03 :deco bold}

  :IncSearch       {:fg base03 :bg cyan1 :deco bold}
  :Search          {:fg base03 :bg cyan2 :deco none}
  :Pmenu           {:fg base2 :bg base02 :deco none}
  :PmenuSel        {:fg base3 :bg base01 :deco bold}
  :PmenuSbar       {:bg base02 :deco none}
  :PmenuThumb      {:bg base00 :deco none}
  :TabLine         {:fg base2 :bg base03 :deco none}
  :TabLineSel      {:fg base03 :bg magenta1 :deco bold}
  :TabLineFill     {:fg base2 :bg base03 :deco none}

  :SpellBad        {:deco undercurl}
  :SpellCap        {:deco undercurl}
  :SpellRare       {:deco undercurl}
  :SpellLocal      {:deco undercurl}

  :DiffAdd         {:fg cyan1 :bg cyan01 :deco none}
  :DiffChange      {:fg magenta1 :bg magenta01 :deco none}
  :DiffDelete      {:fg magenta1 :bg magenta01 :deco none}
  :DiffText        {:fg magenta3 :bg magenta01 :deco bold}
  :diffAdded       {:fg cyan1 :bg cyan01 :deco none}
  :diffRemoved     {:fg magenta1 :bg magenta01 :deco none}
  :Directory       {:fg teal2 :deco none}
  :ErrorMsg        {:fg red1 :bg none :deco none}
  :SignColumn      {:fg base2 :bg base02 :deco none}
  :MoreMsg         {:fg blue1 :deco none}
  :ModeMsg         {:deco bold}
  :Question        {:fg fg :deco none}
  :WarningMsg      {:fg red1 :deco none}
  :WildMenu        {:fg base3 :bg base00 :deco bold}
  :ColorColumn     {:fg none :bg red01 :deco none}
  :GitGutterAdd    {:fg cyan1 :bg base02 :deco bold}
  :GitGutterChange {:fg magenta1 :bg base02 :deco bold}
  :GitGutterDelete {:fg magenta1 :bg base02 :deco bold}

  :makeIdent :Type
  :makeSpecTarget :Special
  :makeTarget :Function
  :makeCommands none})

(def terminal-styles
  [base03
   magenta2
   teal2
   violet2
   cyan2
   blue1
   violet3
   base3
   blue3
   base03
   base03
   base03
   blue2
   violet2
   base03
   base03])

(def lightline-styles
  {:normal
    {:left    [{:fg base03 :bg blue1} {:fg base03 :bg blue2}]
     :middle  [{:fg base03 :bg blue3}]
     :right   [{:fg base03 :bg blue1} {:fg base03 :bg blue2}]
     :error   [{:fg red1 :bg base02}]
     :warning [{:fg violet1 :bg base01}]}
   :insert
    {:left    [{:fg base03 :bg cyan1} {:fg base03 :bg cyan2}]
     :middle  [{:fg base03 :bg cyan3}]
     :right   [{:fg base03 :bg cyan1} {:fg base03 :bg cyan2}]}
   :visual
    {:left    [{:fg base03 :bg violet1} {:fg base03 :bg violet2}]
     :middle  [{:fg base03 :bg violet3}]
     :right   [{:fg base03 :bg violet1} {:fg base03 :bg violet2}]}
   :replace
    {:left    [{:fg base03 :bg magenta1} {:fg base03 :bg magenta2}]
     :middle  [{:fg base03 :bg magenta3}]
     :right   [{:fg base03 :bg magenta1} {:fg base03 :bg magenta2}]}
   :tabline
    {:left    [{:fg base2 :bg base01}]
     :middle  [{:fg base2 :bg base03}]
     :right   [{:fg base03 :bg violet1} {:fg base02 :bg violet2}]
     :tabsel  [{:fg base03 :bg violet1}]}})

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
    [(str "\\ " (keyword->vs-key mode) "{")
     (map ll-position-styles->vs position-styles)
     "\\ },"])))

;; Generate vimscript

(defn build-main-colorscheme-vs [syntax-styles terminal-styles]
  (str/join
   "\n"
   (flatten
    ["\" Styles"
     "\" =========="
     (map syntax-style->vs syntax-styles)
     ""
     (if terminal-styles
       ["\" Terminal Colors"
        "\" ==========="
        (map-indexed terminal-style->vs terminal-styles)])])))

(defn build-lightline-colorscheme-vs [lightline-styles]
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
  (let [main-colorscheme-vs (build-main-colorscheme-vs syntax-styles terminal-styles)
        main-colorscheme-path "colors/hydrangea.vim"
        lightline-colorscheme-vs (build-lightline-colorscheme-vs lightline-styles)
        lightline-colorscheme-path "autoload/lightline/colorscheme/hydrangea.vim"]
    (spit main-colorscheme-path main-colorscheme-vs)
    (println main-colorscheme-vs)
    (println (str "Wrote to file: " main-colorscheme-path))
    (if lightline-colorscheme-vs
      (spit lightline-colorscheme-path lightline-colorscheme-vs)
      (println lightline-colorscheme-vs)
      (println (str "Wrote to file: " lightline-colorscheme-path))
      (println "Skipping lightline colorscheme..."))))

(comment (build syntax-styles terminal-styles lightline-styles))



