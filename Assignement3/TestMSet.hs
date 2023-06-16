import Data.List
import MultiSet
import System.IO.Unsafe

main = do 
    let filename1 = "./aux_files/anagram.txt"
    let filename2 = "./aux_files/anagram-s1.txt"
    let filename3 = "./aux_files/anagram-s2.txt"
    let filename4 = "./aux_files/margana2.txt"
    
    let m1 = unsafePerformIO(createMSet filename1)
    let m2 = unsafePerformIO(createMSet filename2)
    let m3 = unsafePerformIO(createMSet filename3)
    let m4 = unsafePerformIO(createMSet filename4) 

    print (
        "1) By doing 'm1 == m4' the result is "++ show (m1 == m4) ++ 
        ", but we can demostrate that the elements in these "++
        "two sets are equal by compare them. "++ 
        "The result of 'elems m1 == elems m4' is " ++
        show(elems m1 == elems m4) ++
        ".")
        
    print(
        "2) Let's m2Um3 be the union between m2 and m3. "++
        "The result of 'm1 == m2Um3' is " ++
        show(m1 == (MultiSet.union m2 m3)))
    
    --writeMSet m1 "new1.txt"
    --writeMSet m2 "new2.txt"
    writeMSet m1 "anag-out.txt"
    writeMSet m4 "gana-out.txt"


-- generic accessor function to order a list
-- used to 'ciaoify' strings. It uses the sort function from Data.List
ciaoify :: Ord a => [[a]] -> [[a]] 
ciaoify [] = []
ciaoify (w:wList) = (sort w) : ciaoify wList

-- accessor function to fill an mset given a list of strings
fill :: Eq a => MSet a -> [a] -> MSet a
fill (MS mset) [x]  = add (MS mset) x
fill (MS mset) (w:ws) = fill (add (MS mset) w) ws  

-- accessor function that takes a mset and return the same mset parsed
-- as string, using the format described in the Assignement
parseMSet :: Show a => MSet a -> [Char]
parseMSet (MS []) = ""
parseMSet (MS ((a,b):ab)) = (show a)++" - "++(show b)++"\n"++ parseMSet (MS ab)

-- this function create a mset given a text file 
-- uses the accessor function implemented above and 
-- some the functions 'words' and 'readFile' by Prelude
createMSet :: FilePath -> IO (MSet [Char])
createMSet filename = do
    content <- readFile filename
    let list = words content
    let ciaoList = ciaoify list
    let mset = empty 
    let mset' = fill mset ciaoList
    return mset'

-- this function takes a MSet and a path to a file and write it down
-- using the format described in the Assignement. It uses the Prelude
-- function writeFile and the support function parseMSet 
writeMSet :: Show a => MSet a -> FilePath -> IO ()
writeMSet mset filename =
    writeFile filename (parseMSet mset)



