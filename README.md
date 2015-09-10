# ownerfinder

A Clojure library that will read in a list of files, then generate a set of user/group names that represents the
file permissions for the 

## Usage

lein run /the/root/directory

## How it works
First, use the findowner.sh shell command found in the scripts directry of
jboss_cm project. Run that with the proper directory target (default is /NAS)

Once you've created a dump of all file owner/group in /NAS, move that .csv
file to the resources/data directory of the ownerfinder project.

You can run the ownerfinder applet by doing

lein run nas-props-dump.csv output-file.csv

This will run the parsing process on the nas-props-dump.csv file and result
in a unique set of owner/group tags in the output-file.csv file.


## Problems to solve
- The header is still being dumped into the results
- The results are in arbitrary order. Would be nice to sort them by OWNERID/GROUPID


## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
