hi clear
if exists('syntax_on')
  syntax reset
endif
let g:colors_name = 'hydrangea'
set background=dark

" Styles
" ==========
hi Normal guifg=#c3d5ec ctermfg=252 guibg=#1e222c ctermbg=235
hi Cursor guifg=NONE ctermfg=NONE guibg=#edf5ff ctermbg=255 gui=NONE cterm=NONE
hi CursorIM guifg=NONE ctermfg=NONE guibg=#edf5ff ctermbg=255
hi CursorLine guifg=NONE ctermfg=NONE guibg=#2a303b ctermbg=236 gui=bold cterm=bold
hi CursorColumn guifg=NONE ctermfg=NONE guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi Visual guifg=NONE ctermfg=NONE guibg=#3b4351 ctermbg=238 gui=NONE cterm=NONE
hi VisualNOS guifg=fg ctermfg=fg gui=underline cterm=underline
hi Folded guifg=#c3d5ec ctermfg=252 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi FoldColumn guifg=#c3d5ec ctermfg=252 guibg=#1e222c ctermbg=235 gui=NONE cterm=NONE
hi Title guifg=#e242ac ctermfg=162 guibg=NONE ctermbg=NONE gui=bold cterm=bold
hi StatusLine guifg=#c3d5ec ctermfg=252 guibg=#3b4351 ctermbg=238 gui=NONE cterm=NONE
hi StatusLineNC guifg=#586374 ctermfg=241 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi VertSplit guifg=#2a303b ctermfg=236 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi LineNr guifg=#586374 ctermfg=241 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi CursorLineNr guifg=#edf5ff ctermfg=255 guibg=#586374 ctermbg=241 gui=bold cterm=bold
hi SpecialKey guifg=#064253 ctermfg=23 guibg=#169ec4 ctermbg=38 gui=bold cterm=bold
hi NonText guifg=#586374 ctermfg=241 guibg=#1e222c ctermbg=235 gui=NONE cterm=NONE
hi MatchParen guifg=#e91e63 ctermfg=161 guibg=NONE ctermbg=NONE gui=bold cterm=bold
hi Comment guifg=#586374 ctermfg=241 gui=NONE cterm=NONE
hi Constant guifg=#36c2c2 ctermfg=44 guibg=#134242 ctermbg=23 gui=NONE cterm=NONE
hi link String Constant
hi Number guifg=#56c7ee ctermfg=81 guibg=#064253 ctermbg=23 gui=NONE cterm=NONE
hi Identifier guifg=#edf5ff ctermfg=255 gui=bold cterm=bold
hi Function guifg=#edf5ff ctermfg=255 gui=bold cterm=bold
hi Statement guifg=#537dd5 ctermfg=68 gui=bold cterm=bold
hi Operator guifg=#e242ac ctermfg=162 gui=NONE cterm=NONE
hi Include guifg=#996ddb ctermfg=98 gui=NONE cterm=NONE
hi PreProc guifg=#c398fe ctermfg=183 gui=NONE cterm=NONE
hi Type guifg=#e242ac ctermfg=162 gui=NONE cterm=NONE
hi StorageClass guifg=#537dd5 ctermfg=68 gui=bold cterm=bold
hi Structure guifg=#e242ac ctermfg=162 gui=NONE cterm=NONE
hi Typedef guifg=#537dd5 ctermfg=68 gui=bold cterm=bold
hi Special guifg=#8baafe ctermfg=111 guibg=NONE ctermbg=NONE gui=bold cterm=bold
hi Underlined guifg=fg ctermfg=fg gui=underline cterm=underline
hi Ignore guifg=bg ctermfg=bg
hi Error guifg=#e91e63 ctermfg=161 guibg=#681c36 ctermbg=52 gui=bold cterm=bold
hi Todo guifg=#c3d5ec ctermfg=252 guibg=#1e222c ctermbg=235 gui=bold cterm=bold
hi IncSearch guifg=#1e222c ctermfg=235 guibg=#169ec4 ctermbg=38 gui=bold cterm=bold
hi Search guifg=#1e222c ctermfg=235 guibg=#56c7ee ctermbg=81 gui=NONE cterm=NONE
hi Pmenu guifg=#c3d5ec ctermfg=252 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi PmenuSel guifg=#edf5ff ctermfg=255 guibg=#3b4351 ctermbg=238 gui=bold cterm=bold
hi PmenuSbar guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi PmenuThumb guibg=#586374 ctermbg=241 gui=NONE cterm=NONE
hi TabLine guifg=#c3d5ec ctermfg=252 guibg=#1e222c ctermbg=235 gui=NONE cterm=NONE
hi TabLineSel guifg=#1e222c ctermfg=235 guibg=#e242ac ctermbg=162 gui=bold cterm=bold
hi TabLineFill guifg=#c3d5ec ctermfg=252 guibg=#1e222c ctermbg=235 gui=NONE cterm=NONE
hi SpellBad gui=undercurl cterm=undercurl
hi SpellCap gui=undercurl cterm=undercurl
hi SpellRare gui=undercurl cterm=undercurl
hi SpellLocal gui=undercurl cterm=undercurl
hi DiffAdd guifg=#169ec4 ctermfg=38 guibg=#064253 ctermbg=23 gui=NONE cterm=NONE
hi DiffChange guifg=#e242ac ctermfg=162 guibg=#68024b ctermbg=89 gui=NONE cterm=NONE
hi DiffDelete guifg=#e242ac ctermfg=162 guibg=#68024b ctermbg=89 gui=NONE cterm=NONE
hi DiffText guifg=#ffc3e4 ctermfg=218 guibg=#68024b ctermbg=89 gui=bold cterm=bold
hi diffAdded guifg=#169ec4 ctermfg=38 guibg=#064253 ctermbg=23 gui=NONE cterm=NONE
hi diffRemoved guifg=#e242ac ctermfg=162 guibg=#68024b ctermbg=89 gui=NONE cterm=NONE
hi Directory guifg=#36c2c2 ctermfg=44 gui=NONE cterm=NONE
hi ErrorMsg guifg=#e91e63 ctermfg=161 guibg=NONE ctermbg=NONE gui=NONE cterm=NONE
hi SignColumn guifg=#c3d5ec ctermfg=252 guibg=#2a303b ctermbg=236 gui=NONE cterm=NONE
hi MoreMsg guifg=#537dd5 ctermfg=68 gui=NONE cterm=NONE
hi ModeMsg gui=bold cterm=bold
hi Question guifg=fg ctermfg=fg gui=NONE cterm=NONE
hi WarningMsg guifg=#e91e63 ctermfg=161 gui=NONE cterm=NONE
hi WildMenu guifg=#edf5ff ctermfg=255 guibg=#586374 ctermbg=241 gui=bold cterm=bold
hi ColorColumn guifg=NONE ctermfg=NONE guibg=#681c36 ctermbg=52 gui=NONE cterm=NONE
hi GitGutterAdd guifg=#169ec4 ctermfg=38 guibg=#2a303b ctermbg=236 gui=bold cterm=bold
hi GitGutterChange guifg=#e242ac ctermfg=162 guibg=#2a303b ctermbg=236 gui=bold cterm=bold
hi GitGutterDelete guifg=#e242ac ctermfg=162 guibg=#2a303b ctermbg=236 gui=bold cterm=bold
hi link makeIdent Type
hi link makeSpecTarget Special
hi link makeTarget Function


" Terminal Colors
" ===========
let g:terminal_color_0  = '#1e222c'
let g:terminal_color_1  = '#fe7ecd'
let g:terminal_color_2  = '#36c2c2'
let g:terminal_color_3  = '#c398fe'
let g:terminal_color_4  = '#56c7ee'
let g:terminal_color_5  = '#537dd5'
let g:terminal_color_6  = '#e2ccfe'
let g:terminal_color_7  = '#edf5ff'
let g:terminal_color_8  = '#c9d4fd'
let g:terminal_color_9  = '#1e222c'
let g:terminal_color_10  = '#1e222c'
let g:terminal_color_11  = '#1e222c'
let g:terminal_color_12  = '#8baafe'
let g:terminal_color_13  = '#c398fe'
let g:terminal_color_14  = '#1e222c'
let g:terminal_color_15  = '#1e222c'