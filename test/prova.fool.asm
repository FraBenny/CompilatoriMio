push 0
push 45
push 44
push 54
push 3
push classSecond
new
push 9
push 10
push 21
push 32
push 3
push classSecond
new
push 0
push 4
push 7
push 2
push classFirst
new
lfp
push classSecond
push 0
add
lc
js
lfp
push classFirst
push 2
add
lc
js
add
push 1
add
print
halt

function0:
cfp
lra
push 1
push 3
lfp
add
lw
add
lw
push 1
add
push 2
mult
srv
sra
sfp
lrv
lra
js

function1:
cfp
lra
push 1
srv
sra
sfp
lrv
lra
js

function2:
cfp
lra
push 2
push 2
lfp
add
lw
add
lw
srv
sra
sfp
lrv
lra
js

function3:
cfp
lra
push 100
srv
sra
sfp
lrv
lra
js

function4:
cfp
lra
push 3
push 0
lfp
add
lw
add
lw
srv
sra
sfp
lrv
lra
js
classSecond:
function0
function1
function2
function3
function4
classFirst:
function0
function1
function2
