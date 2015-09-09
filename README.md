# ownerfinder

A Clojure library that will read in a list of files, then generate a set of user/group names that represents the
file permissions for the 

## Usage

lein run /the/root/directory

## How it works
Given a root directory
Generate a list of all files.
For each file, check the user/group names. Add the pair to a Set of #{[user group]}.

## Problems to solve
- How to get a list of all files in a given subdirectory in Clojure

## Steps to solve
- Create a function called from -main that just generates a seq of file names recursive from root
- Given the list of all file names, map each to its owner/group
- Reduce the list of owner/groups to a Set of unique owner/group entries

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
