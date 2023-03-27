open System 

let input = Console.ReadLine().Split " "
let r = double input.[0]
let f = double input.[1]
let count = f/r
let rotation = int (f/r)
let dec = count - double rotation

if rotation % 2 = 0 && dec < 0.5 then printfn "%s" "up"
if rotation % 2 = 0 && dec > 0.5 then printfn "%s" "down"
if rotation % 2 = 1 && dec < 0.5 then printfn "%s" "down"
if rotation % 2 = 1 && dec > 0.5 then printfn "%s" "up"

