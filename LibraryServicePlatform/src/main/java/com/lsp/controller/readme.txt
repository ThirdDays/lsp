controller层的中的方法的处理步骤：
1.接受来自客户端发送过来的数据，有时候需要对其进行一次封装。
2.调用service层服务代码，并将从客户端接收到的数据传入service层，最后接受service传到controller层的数据
3.将从service接收到的数据发送到客户端或将数据转发至指定的地方。