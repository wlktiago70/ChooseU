/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */


package userclasses;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import generated.StateMachineBase;
import com.codename1.ui.*; 
import static com.codename1.ui.Dialog.TYPE_INFO;
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.Candidate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    private static final String CANDIDATES_TBL = "StoredData";
    private static final String PREV_CONF_TBL = "ConfigData";
    private static final String EEGG = "_CW_";
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        Util.register("Candidate",Candidate.class);
    }


    @Override
    protected void onMain_ExecuteAction(Component c, ActionEvent event) {
        Container candidateList = findCandidateList(c);
        Container config = findConfig(c);
        String text = findText(c).getText().trim();
        Vector<Candidate> vec = (Vector<Candidate>)Storage.getInstance().readObject(CANDIDATES_TBL);
        Vector<Candidate> cfg = (Vector<Candidate>)Storage.getInstance().readObject(PREV_CONF_TBL);
        if(text.length() > 0){
            // If input is the special command, go to configurations
            if(text.equalsIgnoreCase(EEGG)){
                candidateList.removeAll();
                candidateList.setHidden(true);
                config.setHidden(false);
                config.setVisible(true);
                findInfo(c).setText("Change weights");
            }
            else{
                candidateList.setHidden(false);
                config.setHidden(true);                
                if(vec == null){
                    vec = new Vector<Candidate>();
                }
                if(cfg == null){
                    cfg = new Vector<Candidate>();
                }
                if(text.equalsIgnoreCase("%delsto")){
                    Storage.getInstance().clearStorage();
                }
                else if(text.startsWith("%set:")){
                    List<String> cfgParam = StringUtil.tokenize(text,":");
                    if(cfgParam.size() == 3){
                        if(!containsIn(cfgParam.get(1),cfg)){
                            cfg.add(new Candidate(cfgParam.get(1),Integer.parseInt(cfgParam.get(2))));
                        }
                        else{
                            for(Candidate a: cfg){
                                if(a.getName().equalsIgnoreCase(cfgParam.get(1))){
                                    a.setWeight(Integer.parseInt(cfgParam.get(2)));
                                    break;
                                }
                            }
                        }
                        Storage.getInstance().writeObject(PREV_CONF_TBL, cfg);
                    }
                    findText(c).clear();
                }
                else if(!containsIn(text,vec)){
                    // If the name does not exist in our database
                    if(Dialog.show("Confirm", "Do you want to include this one as new candidate?", "OK", "Cancel")) {
                        int weight = 1;
                        for(Candidate a: cfg){
                            if(a.getName().equalsIgnoreCase(text)){
                                // If there is an previous configuration for this candidate, apply it
                                weight = a.getWeight();
                                break;
                            }
                        }
                        vec.addElement(new Candidate(text,weight));
                        findText(c).setText("");
                        Storage.getInstance().writeObject(CANDIDATES_TBL, vec);
                        findInfo(c).setText("New candidate stored successfully!");
                        findCandidateList(c).add(new Button(text));
                    }                    
                }
                else{
                    findInfo(c).setText("Candidate already stored!");
                }
            }
        }
        else{
            // If no text inside the text field, it is time to choose a candidate
            String choosenCandidate = choose(vec);
            Dialog.show(null, "The choosen candidate is "+choosenCandidate, TYPE_INFO, null, "OK", null, 30000);
            findInfo(c).setText("The choosen candidate is "+choosenCandidate);            
        }
        c.getComponentForm().revalidate();
    }

    @Override
    protected void onMain_TextAction(Component c, ActionEvent event) {    
    }

    @Override
    protected void onCreateMain() {
    }

    @Override
    protected void beforeMain(Form f) {
    }

    @Override
    protected void postMain(Form f) {
        renderCandidateList(f.getContentPane());
    }

    @Override
    protected void onMain_RbAllAction(Component c, ActionEvent event) {
        findAllWeight(c).setEditable(true);
        findIndividual(c).setEditable(false);
        findIndWeight(c).setEditable(false);
        
        findAllWeight(c).setVisible(true);
        findIndividual(c).setVisible(false);
        findIndWeight(c).setVisible(false); 

        c.getComponentForm().revalidate();
    }

    @Override
    protected void onMain_RbIndAction(Component c, ActionEvent event) {
        findAllWeight(c).setEditable(false);
        findIndividual(c).setEditable(true);
        findIndWeight(c).setEditable(true);
        
        findAllWeight(c).setVisible(false);
        findIndividual(c).setVisible(true);
        findIndWeight(c).setVisible(true); 

        c.getComponentForm().revalidate();
    }

    @Override
    protected void onMain_ApplyAction(Component c, ActionEvent event) {
        Vector<Candidate> vec = (Vector<Candidate>)Storage.getInstance().readObject(CANDIDATES_TBL);
        printCandidateVector(vec);
        if(findRbAll(c).isSelected()){
            for(Candidate a: vec){
                a.setWeight(findAllWeight(c).getProgress());
            }
        }
        else{
            List<String> ind = StringUtil.tokenize(findIndividual(c).getText(),";");
            for(String s: ind){
                for(Candidate a: vec){
                    if(a.getName().equalsIgnoreCase(s.trim())){
                        a.setWeight(findIndWeight(c).getProgress());
                        break;
                    }
                }
            }
            
        }
        Storage.getInstance().writeObject(CANDIDATES_TBL, vec);
        printCandidateVector(vec);
        closeConfig(c);
    }
    
    @Override
    protected void onMain_ConfigCancelAction(Component c, ActionEvent event) {
        closeConfig(c);    
    }

    private boolean containsIn(String name, Vector<Candidate> vec){
        for(Candidate c: vec){
            if(name.equalsIgnoreCase(c.getName())){
                return true;
            }
        }
        return false;
    }
    
    private String choose(Vector<Candidate> vec){
        if(vec != null){
            List<String> aux = new ArrayList<String>();
            for(Candidate c: vec){
                if(c.getWeight()>0)
                    for(int i=0;i<c.getWeight();i++)
                        aux.add(c.getName());
            }
            if(aux.size()>0){
                Collections.shuffle(aux);
                return aux.get((new Random()).nextInt(aux.size()));
            }
            else{
                return vec.get((new Random()).nextInt(vec.size())).getName();
            }
        }
        return "<NULL>";
    }

    private void printCandidateVector(Vector<Candidate> vec){
        if(vec != null){
            System.out.println("Printing candidates vector >>>>>>>>>>");
            for(Candidate a: vec){
                System.out.println("Name: "+a.getName());
                System.out.println("   W: "+a.getWeight());
            }
            System.out.println("<<<<<<<< End printing candidates vector");
        }
        else
            System.out.println("<NULL>");
    }
    
    private void renderCandidateList(Component c) {
        Container candidateList = findCandidateList(c);
        Container config = findConfig(c);
        Vector<Candidate> vec = (Vector<Candidate>)Storage.getInstance().readObject(CANDIDATES_TBL);
        candidateList.removeAll();
        if(vec != null){
            for(Candidate a: vec){
                Button b = new Button(a.getName());
                candidateList.add(b);
                b.addActionListener(e -> Log.p("You picked: " + b.getText()));
            }
        }
        candidateList.setHidden(false);
        config.setHidden(true);
        config.setVisible(false);
        c.getComponentForm().revalidate();
    }

    private void closeConfig(Component c){
        Container config = findConfig(c);
        findText(c).setText("");
        findInfo(c).setText("");
        config.setHidden(true);
        config.setVisible(false);
        renderCandidateList(c);
        c.getComponentForm().revalidate();
    }
    
    private Candidate findCandidateByName(String name, Vector<Candidate> vec){
        for(Candidate a: vec)
            if(a.getName().equalsIgnoreCase(name)){
                return a;
            }
        return null;
    }
}
