@echo off
SET /A RAND=%RANDOM% %%100 +1
REM playgame.jar usage: engine map_file_name max_turn_time max_num_turns log_filename player_one player_two
java -jar PlayGame.jar maps/map%RAND%.txt 100000 300 log.txt "java MyBot" "java bots/EnemyBot" | java -jar ShowGame.jar
del log.txt
@echo on