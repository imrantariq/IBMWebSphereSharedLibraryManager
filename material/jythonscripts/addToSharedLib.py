# Usage: wsadmin -f addToSharedLib.py libname jarfile
#Usage2:  -lang jython -user wasadmin -password P1rean123 -f addToSharedLib.py libname jarfile
libname = sys.argv[0]
jarfile = sys.argv[1]

print libname
print jarfile

cellname=AdminControl.getCell()
cellid=AdminConfig.getid('/Cell:'+AdminControl.getCell()+'/')

print cellname
print cellid

# Get the list of shared libraries
l = AdminConfig.list('Library', cellid)

print l

# Create the library if it does not exist yet
if l.find(libname) == -1:
    AdminConfig.create('Library', cellid, [['name', libname], ['classPath', jarfile]])
    
# If the library is found, check for the requested library
else:
    for lib in l.splitlines():
        thislibname = AdminConfig.showAttribute(lib, 'name')
        if thislibname == libname:
            thisliblist = AdminConfig.showAttribute(lib, 'classPath')
            if thisliblist.find(jarfile) == -1:
                newliblist = thisliblist+';'+jarfile
                params = [];
                params.append(["classPath", newliblist]);
                AdminConfig.modify(lib, params)
                
                
AdminConfig.save()    