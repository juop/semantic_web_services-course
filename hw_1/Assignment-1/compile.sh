#!/bin/bash

`pandoc -f markdown -t html -o doc.pdf.html -s -N --number-offset=0 --template=css/hdoc.tpl -H css/hdoc_pdf.css.inc -H css/hdoc_syntax.css.inc --highlight-style pygments doc.md`

`prince doc.pdf.html -o doc.pdf`
