
-- MSet data definition
module MultiSet where

    data MSet a = MS [(a, Int)] deriving (Show) 
            
    -- MSet as instance of Eq, the definition of the inner function msequality 
    -- can be found below the msequality have to be performed twice (swithcing arguments), 
    -- because it simply checks whether all the elements of the first set are in the second set:
    -- for example, [(1,2), (2,3)] == [(1,2), (2,3), (3,4)] should return False, but it would return 
    -- True if the msequality would be applied just once
    instance (Eq a) => Eq (MSet a) where
        (MS x) == (MS y) = (msequality x y) && (msequality y x)

    -- The function msequality uses the function check as support:
    -- the check function return a boolean if the couple (a,b) is in the list 
    -- passed as second argument
    check (a,b) ((c,d):y) = do
        if a == c then do 
            if b == d then 
                True
            else
                False
        else
            check (a,b) y  

    msequality x [] = False
    msequality [] y = True
    msequality (a:x) y = (check a y) && (msequality x y)
----------------------------------------------------------

    -- MSet as instance of Foldable, defining the foldMap function 
    instance Foldable MSet where
        foldMap f (MS []) = mempty
        foldMap f (MS ((a,b):xs)) = f a <> foldMap f (MS xs)

    -- mapMSet definition: the funcion mapMSet uses the convert function as support
    -- which converts simple lists of type (a,Int) into lists of type (b,Int)
    -- the function was designed to work passing function as 
    -- ceiling, floor, truncate, round, fromInteger, fromRational ecc.. 
    convert :: (a -> b) -> [(a, Int)] -> [(b,Int)]
    convert f [] = []
    convert f ((a,b):ab) = (f a,b):convert f ab

    mapMSet :: (a -> b) -> MSet a -> MSet b
    mapMSet f mset = create_dict (convert f (get_dict mset))
--------------------------------------------------------



    -- Accessor functions
    --
    --

    -- create a list of [(a,Int)] 
    get_dict :: MSet a -> [(a,Int)]
    get_dict (MS a) = a

    -- create an MSet a given a [(a, Int)]
    create_dict :: [(a,Int)] -> MSet a
    create_dict a = (MS a)

    --check if a couple (a,b) is into a list [(a,b)]
    check_sub :: (Ord b, Eq a) => (a, b) -> [(a, b)] -> Bool
    check_sub (v1, r1) [] = False
    check_sub (v1, r1) ((a, b):xs) = do
        if v1 == a then
            if r1 >= b then True else False
        else check_sub (v1, r1) xs
--------------------------------------------------

--------------------------------------------------
    -- Required functions
    -- 
    -- The add and union functions uses support functions which takes general lists
    -- thanks to the functions get_dictionary. They also return  
    -- a MSet thanks to the create_dict function 
    --
    --
    -- ADD
    -- add a new pair in a MSet 
    add :: Eq a => MSet a -> a -> MSet a
    add mset v = create_dict(add_ms (get_dict mset) v)

    --support function that takes a general list of touples, 
    --add a touple then gives back a list of touple
    add_ms :: (Num b, Eq a) => [(a, b)] -> a -> [(a, b)]
    add_ms [] v = [(v,1)]
    add_ms ((a,b):xs) v = if v == a then do (a, b+1):xs else (a,b):add_ms xs v
--------------------------------------------------------------------------

    -- UNION
    -- merge two MSets summing the repetition of the same values
    union :: Eq a => MSet a -> MSet a -> MSet a
    union mset1 mset2 =  create_dict(union_ms (get_dict mset1) (get_dict mset2))

    -- support function used to recursive insert into the second MSet the head of the first MSet
    union_ms :: (Eq a, Num b) => [(a, b)] -> [(a, b)] -> [(a, b)]
    union_ms [] ms2 = ms2
    union_ms ((a,b):ms1) ms2 = union_ms ms1 (insert (a,b) ms2)

    -- support funtion to insert a new pair in a dict or increment the repetitions if it exist
    insert :: (Eq a, Num b) => (a, b) -> [(a, b)] -> [(a, b)]
    insert (a,b) [] = [(a,b)]
    insert (a,b) ((c,d):ms2) = if a == c then (c,d+b):ms2 else (c,d):insert (a,b) ms2
------------------------------------------------------------------------------------------

    -- OCCS
    -- return a the repetition of the element v into the mset, 0 if it is not present
    occs :: Eq a => MSet a -> a -> Int
    occs (MS []) v = 0 
    occs (MS ((a,b):mset)) v = if v == a then b else occs (MS mset) v  

    -- ELEMS
    -- return a list of values contanied in the mset 
    elems :: MSet a -> [a]
    elems (MS []) = []
    elems (MS ((a,b):xs)) = a:elems (MS xs) 

    -- SUBEQ
    -- takes two msets and return true if all the elements
    -- in the first mset are also in the second, with the same 
    -- multiplicity at least
    subeq :: Eq a => MSet a -> MSet a -> Bool
    subeq (MS []) (MS []) = True
    subeq (MS []) (MS xs) = True
    subeq (MS xs) (MS []) = False
    subeq (MS ((v1, r1):xs)) (MS y) = if check_sub (v1, r1) y then subeq (MS xs) (MS y) else False

    -- EMPTY 
    empty :: MSet a
    empty = (MS [])