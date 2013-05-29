process
=======

javaのプロセス起動停止時の処理とか

使い方
-----

1. AbstractShutdownHookを継承したクラスを作る。
2. release()に、停止時の処理を実装する。
3. doExecute()にメイン処理を実装する。
4. main()メソッドにて、1.で実装したクラスのインスタンスを作成し、execute()メソッドを実行する。
5. Ctrl + Cでの停止時や、プロセスをkillすると、release()が呼ばれるので、適切に停止することができる。
6. ただし、kill -9をすると、release()は呼ばれない。

