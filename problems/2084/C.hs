import Control.Monad (forM_, replicateM)
import Data.List (intercalate, sort, words)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

type Step = (Int, Int) -- i and j

solve :: ([Integer], [Integer]) -> Maybe [Step]
solve (a, b) = Nothing

isDone :: Eq a => [a] -> [a] -> Bool
isDone a b = a == reverse b

main :: IO ()
main = do
  -- get size
  t <- readLn :: IO Int
  -- IO friendly parse
  lists <- replicateM t $ do
    _ <- getLine -- toss the “length” line
    line1 <- fmap (map (read :: String -> Integer) . words) getLine
    line2 <- fmap (map (read :: String -> Integer) . words) getLine
    return (line1, line2)

  -- process and print
  let results = map (SOLUTION) lists
  forM_ results putStrLn
