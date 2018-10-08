/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Slider", com.codename1.ui.Slider.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Main";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Slider", com.codename1.ui.Slider.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.TextField findIndividual(Component root) {
        return (com.codename1.ui.TextField)findByName("individual", root);
    }

    public com.codename1.ui.TextField findIndividual() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("individual", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("individual", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRbAll(Component root) {
        return (com.codename1.ui.RadioButton)findByName("rbAll", root);
    }

    public com.codename1.ui.RadioButton findRbAll() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("rbAll", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("rbAll", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findApply(Component root) {
        return (com.codename1.ui.Button)findByName("apply", root);
    }

    public com.codename1.ui.Button findApply() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("apply", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("apply", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findExecute(Component root) {
        return (com.codename1.ui.Button)findByName("execute", root);
    }

    public com.codename1.ui.Button findExecute() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("execute", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("execute", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Slider findIndWeight(Component root) {
        return (com.codename1.ui.Slider)findByName("indWeight", root);
    }

    public com.codename1.ui.Slider findIndWeight() {
        com.codename1.ui.Slider cmp = (com.codename1.ui.Slider)findByName("indWeight", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Slider)findByName("indWeight", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findResult(Component root) {
        return (com.codename1.ui.Container)findByName("result", root);
    }

    public com.codename1.ui.Container findResult() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("result", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("result", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findConfigCancel(Component root) {
        return (com.codename1.ui.Button)findByName("configCancel", root);
    }

    public com.codename1.ui.Button findConfigCancel() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("configCancel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("configCancel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findCandidateList(Component root) {
        return (com.codename1.ui.Container)findByName("candidateList", root);
    }

    public com.codename1.ui.Container findCandidateList() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("candidateList", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("candidateList", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findText(Component root) {
        return (com.codename1.ui.TextField)findByName("text", root);
    }

    public com.codename1.ui.TextField findText() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("text", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("text", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRbInd(Component root) {
        return (com.codename1.ui.RadioButton)findByName("rbInd", root);
    }

    public com.codename1.ui.RadioButton findRbInd() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("rbInd", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("rbInd", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Slider findAllWeight(Component root) {
        return (com.codename1.ui.Slider)findByName("allWeight", root);
    }

    public com.codename1.ui.Slider findAllWeight() {
        com.codename1.ui.Slider cmp = (com.codename1.ui.Slider)findByName("allWeight", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Slider)findByName("allWeight", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConfig(Component root) {
        return (com.codename1.ui.Container)findByName("config", root);
    }

    public com.codename1.ui.Container findConfig() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("config", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("config", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findInfo(Component root) {
        return (com.codename1.ui.Label)findByName("info", root);
    }

    public com.codename1.ui.Label findInfo() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("info", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("info", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main")) {
            if("text".equals(c.getName())) {
                onMain_TextAction(c, event);
                return;
            }
            if("execute".equals(c.getName())) {
                onMain_ExecuteAction(c, event);
                return;
            }
            if("rbAll".equals(c.getName())) {
                onMain_RbAllAction(c, event);
                return;
            }
            if("rbInd".equals(c.getName())) {
                onMain_RbIndAction(c, event);
                return;
            }
            if("individual".equals(c.getName())) {
                onMain_IndividualAction(c, event);
                return;
            }
            if("apply".equals(c.getName())) {
                onMain_ApplyAction(c, event);
                return;
            }
            if("configCancel".equals(c.getName())) {
                onMain_ConfigCancelAction(c, event);
                return;
            }
        }
    }

      protected void onMain_TextAction(Component c, ActionEvent event) {
      }

      protected void onMain_ExecuteAction(Component c, ActionEvent event) {
      }

      protected void onMain_RbAllAction(Component c, ActionEvent event) {
      }

      protected void onMain_RbIndAction(Component c, ActionEvent event) {
      }

      protected void onMain_IndividualAction(Component c, ActionEvent event) {
      }

      protected void onMain_ApplyAction(Component c, ActionEvent event) {
      }

      protected void onMain_ConfigCancelAction(Component c, ActionEvent event) {
      }

}
