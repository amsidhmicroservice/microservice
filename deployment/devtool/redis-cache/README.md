### To fix the read READ_ONLY error kindly follow the following step.
1. login to the maste pod of redis using folllowing command.
2. kubectl exec -it pods/redis-0 -n redis sh
Then fire the below command with user and pass
3. redis-cli --user myredis --pass Redis@123 -h 127.0.0.1 -p 6379 slaveof no one
4. exit
That's it.
