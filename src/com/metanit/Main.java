package com.metanit;

interface HighConnect{
    public void HighPower();
}

interface LowConnect{
    public void LowPower();
}

class HighVolt implements HighConnect{
    public void HighPower(){
        System.out.println("Телефон заряжаеться с мощностью 380В");
    }
}

class LowVolt implements LowConnect{
    public void LowPower(){
        System.out.println("Телефон заряжаеться с мощностью220В");
    }
}

class Socket{
    private HighConnect highConnect;
    public Socket(HighConnect highConnect){
        this.highConnect = highConnect;
    }
    public void work(){
        highConnect.HighPower();
    }
}

class SocketAdapter implements HighConnect{
    LowConnect lowConnect;
    public SocketAdapter(LowConnect lowConnect){
        this.lowConnect = lowConnect;
    }
    public void HighPower(){
        lowConnect.LowPower();
    }
}
public class Main {
    public static void main(String[] args) {
        HighVolt highVolt = new HighVolt();
        Socket highSocket = new Socket(highVolt);
        highSocket.work();
        SocketAdapter socketAdapter = new SocketAdapter(new LowVolt());
        Socket lowSocket = new Socket(socketAdapter);
        lowSocket.work();
    }
}