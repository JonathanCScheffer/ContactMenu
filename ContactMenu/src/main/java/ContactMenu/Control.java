package ContactMenu;

/**
 * Invoker Class for Command Design Pattern
 * @author = Jonathan Scheffer
 */
public class Control{
    private CommandInterface commandInterface;
    public void setCommand(CommandInterface commandInterface){
        this.commandInterface = commandInterface;
    }
    public void makeCommand(){
        commandInterface.execute();
    }
}