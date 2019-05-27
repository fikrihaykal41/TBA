/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestba;

/**
 *
 * @author afrianhanafi
 */
public class States {
    
    private String line;
    private String num = "Num";
    private String opr = "Opr";
    private String err = "Error";
    private String kurbuka = "Kurbuka";
    private String kurtutup = "Kurtutup";
    
    public boolean stat = true;
    
    public States(String line){
        this.line = line;
    }
    
    public boolean isNum(char c){
        return Character.isDigit(c);
    }
    
    public String start(){
        if(line.equals("")){
            stat = false;
            return err;
        }
        else return check(line);
    }
    
    public String check(String line){
        if(line.length() > 1 && line.charAt(0) == ',') return check(line.substring(1));
        else if(line.charAt(0) == 'E') return stateE(line.substring(1));
        else if(isNum(line.charAt(0))) return stateNum(line.substring(1));
        else if(line.charAt(0) == '+' || line.charAt(0) == '-' || line.charAt(0) == 'x' || line.charAt(0) == ':') return stateOpr(line.substring(1));
        else if(line.charAt(0) == '(') return stateKurbuk(line.substring(1));
        else if(line.charAt(0) == ')') return stateKurtup(line.substring(1));
        else{
            stat = false;
            return err;
        }
    }
    
    public String stateE(String line){
        if(line.equals("")) return err;
        else return check(line);
    }
    
    public String stateNum(String line){
        if(line.equals("")) return num;
        else return check(line);
    }
    
    public String stateOpr(String line){
        if(line.equals("")) return opr;
        else return check(line);
    }
    
    public String stateKurbuk(String line){
        if(line.equals("")) return kurbuka;
        else return check(line);
    }    
    
    public String stateKurtup(String line){
        if(line.equals("")) return kurtutup;
        else return check(line);
    }
    
}