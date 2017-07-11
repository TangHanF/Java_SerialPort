# Java_SerialPort
Java操作串口


调用方式：
- 调用SerialTool的openPort方法返回一个串口对象
- 将该对象传入SerialTool的sendToPort方法进行串口数据发送
- 调用SerialTool的readFromPort读取响应数据
