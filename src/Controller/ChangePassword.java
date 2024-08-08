/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import dao.AdminDao;
/**
 *
 * @author sarjak
 */
public class ChangePassword{
    public String Oldpass;
    public String NewPass;
    public String CPass;
    private boolean isLong(){
        if(CPass.length()>7){return true;}
        else{return false;}
        }
    private boolean OpNpnotSame(){
         if(Oldpass.equals(NewPass)){
             return false;
         }
         return true;
     }
    private boolean NpCpSame(){       
            if(NewPass.equals(CPass)){
             return true;
         }
         return false;
     }
    private boolean isPassMatch(){ 
         AdminDao a=new AdminDao();
         return this.Oldpass.equals(a.getOwnerPass());
     }    
    public String chgPass(){
        if(!(this.Oldpass.isEmpty())&&!(this.NewPass.isEmpty())&& !(this.CPass.isEmpty())){
            if(this.OpNpnotSame()){
                if(this.NpCpSame()){
                    if(this.isPassMatch()){
                       if(this.isLong()){
                        AdminDao a=new AdminDao();
                        if(a.chgPasAdmn(NewPass)){return "Success";}
                        else{return "Failed";}
                       }
                       else{
                           return "NTLG";
                       }
                    }
                    else{
                        return "PSMC";
                    }
                }
                else{
                    return "NPCP";
                }
               }
            else{
                return "OPNP";
            }
        }
        else{
            return "EMPTY";
        }        
     }
}




