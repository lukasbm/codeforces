import Data.List (sort)
import System.IO

-- the minimum of the left set, must be at least as large as the minimum of the gcd params!
-- so start the algorithm with 1 in the left set.
isValid :: [Integer] -> Bool
isValid [a] = True
isValid (m : rs) = let gs = map (gcd m) rs in elem m gs

main = do
  nRaw <- getLine
  let n = read nRaw :: Integer
  numsRaw <- getLine
  let nums = map read $ words numsRaw :: [Integer]
  putStrLn (if isValid (sort nums) then "Yes" else "No")
