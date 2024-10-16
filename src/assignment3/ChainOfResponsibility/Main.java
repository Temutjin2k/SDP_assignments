package assignment3.ChainOfResponsibility;
interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(String URL);
}

class RootHandler implements Handler{
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String URL){
        if (URL.equals("/")){
            System.out.println("Root address");
        }else if (nextHandler != null){
            nextHandler.handleRequest(URL);
        }
    }
}

class ViewHandler implements Handler{
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String URL){
        if (URL.equals("/view")){
            System.out.println("View Address");
        }else if (nextHandler != null){
            nextHandler.handleRequest(URL);
        }
    }
}

class ImageHandler implements Handler{
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String URL){
        if (URL.equals("/view/image.png")){
            System.out.println("You are viewing image");
        }else if (nextHandler != null){
            nextHandler.handleRequest(URL);
        }
    }
}

// This example may be not very useful in real project.
public class Main {
    public static void main(String[] args) {
        Handler root = new RootHandler();
        Handler view = new ViewHandler();
        Handler imageHandler = new ImageHandler();

        root.setNextHandler(view);
        view.setNextHandler(imageHandler);

        root.handleRequest("/");
        root.handleRequest("/view");
        root.handleRequest("/view/image.png");
    }
}
