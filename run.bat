 @echo off

 set cpath=%cd%

 java -jar "%cpath%/auto-dict-0.0.1-SNAPSHOT.jar" --db=fz_aquatic_zf --u=root --p=root --dialect=mysql

 pause
