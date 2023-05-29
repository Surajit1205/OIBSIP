import java.util.*;
class OnlineExamination{
    public static void main(String[] args){
        //Login
        Scanner in=new Scanner(System.in);
        String realid="surajit63",realpassword="abc_123";
        while(true){
            //System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Welcome to Login Portal");
            //System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Enter LoginId: ");
            String id,password;
            id=in.next();
            System.out.print("Enter Password: ");
            password=in.next();
            if(id.equals(realid) && password.equals(realpassword)){
                //Update Profile and Password
                Integer count=0;
                //System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Welcome to Exam Portal");
                //System.out.println("---------------------------------------------------------------------------------------");

                while(true){
                    System.out.println(" 1.Exam \n 2.Update Profile \n 3.Logout");
                    System.out.print("Enter Your Choice:");
                    Integer n=in.nextInt();
                    if(n==1){//Selecting answers for MCQs
                        long examstarttime=System.currentTimeMillis();//Timer and auto submit
                        long endtime=examstarttime+30*1000;
                        //long currenttime=(System.currentTimeMillis())/10000000;
                        while(System.currentTimeMillis()<endtime){
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Exam Exactly Starts Now and Your timer was on mode. \n Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Q1. _____ OWL \n 1.An   2.A   3.The   4.All   5.None");
                            System.out.print("Enter the ans: ");
                            String s=in.next();
                            if(s.equals("1")){
                                count+=1;
                            }
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Submitted First Question Successfully.\n Now Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Q2. _____ One day match \n 1.The   2.An   3.A   4.All   5.None");
                            System.out.print("Enter the ans: ");
                            s=in.next();
                            if(s.equals("3")){
                                count+=1;
                            }
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Submitted Second Question Successfully. \n Now Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Q3. Half _____ hour  \n 1.The   2.An   3.A   4.All   5.None");
                            System.out.print("Enter the ans: ");
                            s=in.next();
                            if(s.equals("2")){
                                count+=1;
                            }
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Submitted Third Question Successfully. \n Now Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Q4. _____ Ganga river \n 1.The   2.An   3.A   4.All   5.None");
                            System.out.print("Enter the ans: ");
                            s=in.next();
                            if(s.equals("1")){
                                count+=1;
                            }
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Submitted Fourth Question Successfully. \n Now Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Q5. _____ University \n 1.The   2.An   3.A   4.All   5.None");
                            System.out.print("Enter the ans: ");
                            s=in.next();
                            if(s.equals("3")){
                                count+=1;
                            }
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("Your Submitted Fifth Question Successfully.\nNow Current time:"+System.currentTimeMillis());
                            System.out.println("---------------------------------------------------------------------------------------");
                        }
                        System.out.println("Your Exam Finishes.\nYou Scored:"+(count*10));
                    }
                    else if(n==2){
                        try{
                            System.out.print("Enter Updated Id:");
                            realid=in.next();
                            System.out.print("Enter Updated Password");
                            realpassword=in.next();
                            System.out.println("Details Updated Successfully");
                        }
                        catch(Exception e){
                            System.out.println("Failed to Update Details");
                        }

                    }
                    else if(n==3){//Closing session and Logout
                        System.exit(0); //Closing session and Logout
                    }
                    else{
                        System.out.println("Enter valid choices");
                    }
                }
            }
            else{
                System.out.println("Your Entered Details are Invalid.Try Again");
            }
        }
    }
}