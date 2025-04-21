import Control.Monad (forM_, replicateM)
import Data.List (intercalate, sort, words)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

-- for each row of length m we can have ceil(m/2) single benches
-- exhaust all single benches first:
-- k -= n * ceil(m / 2)
-- max_bench = 1
-- then "fill the gaps" (column wise)
-- while k > 0:
--    k -= n
--    max_bench += 1
solve :: [Int] -> Int
solve [n, m, k] = let new_k = k - n * ceiling (fromIntegral m / 2) in trace ("new_k: " ++ show new_k) 1 + fillGaps new_k
  where
    fillGaps remainingDesks = if remainingDesks > 0 then 2 + fillGaps (remainingDesks - n) else 0

solve :: [Int] -> Int
solve [n, m, k] = let k_per_row = ceiling (fromIntegral k / fromIntegral n) in placeRow asdsd 
  where
    placeRow :: [Bool] -> Int
    placeRow a increment 
    -- see my notes, is there a closed form for it?
    -- or do i need to simulate it?
    -- this would be more expensive as i would need to count the adjacent benches too
  
-- current approach:
-- have a boolean list of length k_per_row all initialized False (True would mean a desk).
-- for each iteration i (starting from 0) while i * 2 < k:
-- filter list to only include false values
-- in this list, place a cross at index i and m-i-1 (indices refer to subset of list!)
-- 
-- min adjacent benches will increase as optimally as possible, but idk if there is a closed form for it!

main :: IO ()
main = do
  -- get size
  t <- readLn :: IO Int
  -- IO friendly parse
  lists <- replicateM t $ do
    fmap (map (read :: String -> Int) . words) getLine

  -- process and print
  let results = map solve lists
  forM_ results print
