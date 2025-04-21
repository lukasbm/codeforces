import Control.Monad (forM_, replicateM)
import Data.List (intercalate, sort, words)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

solve :: [Int] -> Int
solve [n, m, k] = let k_per_row = ceiling (fromIntegral k / fromIntegral n) in minAdjacentBoxes m k_per_row

minAdjacentBoxes :: Int -> Int -> Int
minAdjacentBoxes n k = ceiling $ fromIntegral k / fromIntegral (n - k + 1)

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
