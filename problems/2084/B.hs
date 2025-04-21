import Control.Monad (forM_, replicateM)
import Data.List (intercalate, sort, words)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

-- the minimum of the left set, must be at least as large as the minimum of the gcd params!
-- so start the algorithm with 1 in the left set.
isValid :: [Integer] -> Bool
isValid [a] = True
isValid [a, b] = a == b
-- isValid (m : rs) = let gs = map (gcd m) rs in trace ("gs (" ++ show m ++ ")= " ++ show gs) not (null gs)
isValid (m : rs) = let gs = filter (\r -> gcd m r == m) rs in answer gs
  where
    answer gs
      | null gs = True
      | length gs == 1 = m `elem` gs
      | length gs > 1 = elem m gs || gcd (head gs) (head $ tail gs) == m

main :: IO ()
main = do
  -- get size
  t <- readLn :: IO Int
  -- IO friendly parse
  lists <- replicateM t $ do
    _ <- getLine -- toss the “length” line
    fmap (map (read :: String -> Integer) . words) getLine -- read & parse the list

  -- process and print
  let results = map (b2s . isValid . sort) lists
  forM_ results putStrLn

-- tester, false positives
-- dbg (sort $ lists !! 17) (b2s . isValid)
-- dbg (sort $ lists !! 22) (b2s . isValid)
-- dbg (sort $ lists !! 28) (b2s . isValid)

b2s :: Bool -> String
b2s True = "Yes"
b2s False = "No"

dbg :: (Show a, Show b) => a -> (a -> b) -> IO ()
dbg inp fun = let msg = "Input: " ++ show inp ++ ", Output: " ++ show (fun inp) in hPutStrLn stderr msg

dbgMsg :: [String] -> String
dbgMsg ss = "[" ++ intercalate ", " ss ++ "]"
