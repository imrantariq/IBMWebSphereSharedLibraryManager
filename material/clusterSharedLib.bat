@ECHO OFF
%1
cd %2
wsadmin.bat -lang jython -user %6 -password %7 -f clusterSharedLib.py %3 %4 %5