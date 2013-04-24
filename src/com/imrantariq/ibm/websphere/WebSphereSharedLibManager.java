package com.imrantariq.ibm.websphere;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import com.imrantariq.ibm.util.AppLogger;
import com.imrantariq.ibm.util.ExtractZipDirectory;
import com.imrantariq.ibm.util.UserInput;

public class WebSphereSharedLibManager extends JFrame {

  private static final long serialVersionUID = 1L;

  static Runtime rt = Runtime.getRuntime();

  private static UserInput userinput = new UserInput();

  Container container;

  int currentDistance;

  private JButton submit;

  private JLabel username;

  private JTextField usernameInput;

  private JLabel password;

  private JPasswordField passwordInput;

  private JLabel websphereHomeDir;

  private JLabel websphereHomeDirlike;

  private JTextField websphereHomeDirInput;

  private JLabel websphereDeplMgr;

  private JTextField websphereDeplMgrInput;

  private JLabel jarsDir;

  private JTextField jarsDirInput;

  private JLabel jarsDirLike;

  private JLabel WebSphereApplicationServer;

  private JTextField WebSphereApplicationServerInput;

  private JLabel singleAndClusterVar;

  private JTextField singleAndClusterVarInput;

  private JLabel sharedLibraryNameVar;

  private JTextField sharedLibraryNameVarInput;

  private JLabel description;

  private JLabel descriptions;

  private JLabel descriptionLineThree;

  private JButton btnBrowse;

  private JButton btnBrowsedir;

  private JRadioButton button1;

  private JRadioButton button2;

  private JButton cancel;

  public WebSphereSharedLibManager() {
    super("IBM WebSphere Shared Lib Manager Installation");
    AppLogger.logInfo("IBM WebSphere Shared Lib Manager in progress...");

    setLayout(null);
    description = new JLabel(
        "IBM WebSphere Shared Lib Manager Installer, will add shared library jars in IBM WebSphere Application server shared library");
    description.setBounds(20, 10, 1000, 25);
    descriptions = new JLabel("Manage Shared Library.");
    descriptions.setBounds(20, 30, 1000, 25);
    descriptionLineThree = new JLabel("Please provide the values in the Required fileds.");
    descriptionLineThree.setBounds(20, 50, 1000, 25);

    username = new JLabel("WAS user ID ");
    username.setBounds(20, 85, 1000, 25);
    usernameInput = new JTextField("wasadmin", 35);
    usernameInput.setEditable(true);
    usernameInput.setBounds(330, 85, 200, 20);

    password = new JLabel("WAS password ");
    password.setBounds(20, 110, 1000, 25);
    passwordInput = new JPasswordField(15);
    passwordInput.setBounds(330, 110, 200, 20);

    jarsDir = new JLabel("Shared Library directory ");
    jarsDir.setBounds(20, 135, 1000, 25);
    jarsDirInput = new JTextField(50);
    jarsDirInput.setBounds(330, 135, 200, 20);
    jarsDirLike = new JLabel("like: (.../Sample/jars)");
    jarsDirLike.setBounds(330, 155, 200, 20);

    btnBrowse = new JButton("..");
    btnBrowse.setBounds(540, 135, 30, 23);
    btnBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
          jarsDirInput.setText(fileChooser.getSelectedFile().toString());
        }
      }
    });

    WebSphereApplicationServer = new JLabel("WAS server name");
    WebSphereApplicationServer.setBounds(20, 180, 1000, 25);
    WebSphereApplicationServerInput = new JTextField("server1", 15);
    WebSphereApplicationServerInput.setEditable(true);
    WebSphereApplicationServerInput.setBounds(330, 180, 200, 20);

    websphereHomeDir = new JLabel("WAS home directory ");
    websphereHomeDir.setBounds(20, 205, 1000, 25);
    websphereHomeDirInput = new JTextField(15);
    websphereHomeDirInput.setBounds(330, 205, 200, 20);
    websphereHomeDirlike = new JLabel("like: (.../IBM/WebSphere/AppServer)");
    websphereHomeDirlike.setBounds(330, 225, 200, 20);
    btnBrowsedir = new JButton("..");
    btnBrowsedir.setBounds(540, 205, 30, 23);
    btnBrowsedir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
          websphereHomeDirInput.setText(fileChooser.getSelectedFile().toString());
        }
      }
    });

    websphereDeplMgr = new JLabel("WAS deployment manager profile name");
    websphereDeplMgr.setBounds(20, 250, 1000, 25);
    websphereDeplMgrInput = new JTextField(15);
    websphereDeplMgrInput.setBounds(330, 250, 200, 20);

    sharedLibraryNameVar = new JLabel("Shared library name: ");
    sharedLibraryNameVar.setBounds(20, 275, 1000, 25);
    sharedLibraryNameVarInput = new JTextField("Shared Library", 15);
    sharedLibraryNameVarInput.setEditable(true);
    sharedLibraryNameVarInput.setBounds(330, 275, 200, 20);

    singleAndClusterVar = new JLabel("Select target server: ");
    singleAndClusterVar.setBounds(20, 300, 1000, 25);
    singleAndClusterVarInput = new JTextField(15);
    singleAndClusterVarInput.setText("1");
    ButtonGroup group = new ButtonGroup();

    button1 = new JRadioButton("Singular", true);
    button1.setBounds(330, 300, 80, 20);
    button2 = new JRadioButton("Cluster", false);
    button2.setBounds(420, 300, 100, 20);
    group.add(button1);
    group.add(button2);
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        singleAndClusterVarInput.setText("1");
      }
    });

    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        singleAndClusterVarInput.setText("2");
      }
    });

    submit = new JButton("Run");
    submit.setBounds(335, 330, 80, 30);
    submit.addActionListener(new ActionListener() {
      @SuppressWarnings({ "deprecation", "static-access" })
      @Override
      public void actionPerformed(ActionEvent event) {
        boolean dir;

        dir = validatePaths(jarsDirInput.getText());
        if (!dir) {
          showErrorMessage("jarsDirInput");
        }

        dir = validatePaths(websphereHomeDirInput.getText());
        if (!dir) {
          showErrorMessage("websphereHomeDirInput");
        }

        if (!singleAndClusterVarInput.getText().equalsIgnoreCase("1") && !singleAndClusterVarInput.getText().equalsIgnoreCase("2")) {
          showErrorMessage("singleAndClusterVarInput");
        }
        if (singleAndClusterVarInput.getText().equalsIgnoreCase("2")) {
          String clusterName = JOptionPane.showInputDialog(null, "Cluster Name");
          if (clusterName != null && !clusterName.isEmpty()) {
            userinput.setClusterName(clusterName);
          }
          else {
            showErrorMessage("clusterName");
          }
        }

        userinput.setAdmin(usernameInput.getText());
        userinput.setPassword(passwordInput.getText());
        userinput.setPluginRootDir(jarsDirInput.getText());
        userinput.setWebsphereHomeDir(websphereHomeDirInput.getText());
        userinput.setWebsphereDeplMgrprofileName(websphereDeplMgrInput.getText());
        userinput.setWebSphereServerName(WebSphereApplicationServerInput.getText());
        userinput.setSingleAndClusterVar(singleAndClusterVarInput.getText());
        userinput.setSharedLibraryName(sharedLibraryNameVarInput.getText());

        AppLogger.logDebug(userinput.toString());

        setVisible(false);
        try {

          String jarsDir = userinput.getPluginRootDir() + "/jarsDir";
          boolean success = (new File(jarsDir)).mkdir();
          if (success) {
            AppLogger.logInfo("Directory: " + jarsDir + " created");
          }
          ExtractZipDirectory unZip = new ExtractZipDirectory();
          String path = userinput.getPluginRootDir();
          File rep = new File(path);
          File[] list = rep.listFiles();
          ArrayList<String> filenames = new ArrayList<String>();
          for (int i = 0; i < list.length; i++) {
            try {
              if (list[i].getName().contains(".zip")) {
                String src1 = path + "/" + list[i].getName();
                ZipFile zipFile = new ZipFile(src1);
                filenames.add(list[i].getName().replace(".zip", ""));
                String des1 = jarsDir + "/" + list[i].getName().replace(".zip", "");
                File file = new File(des1);
                unZip.unzipFileIntoDirectory(zipFile, file);
                AppLogger.logInfo("Done extracting the folders into the directory");
                AppLogger.logDebug("filenames = " + filenames);
                AppLogger.logDebug("jarsDir = " + jarsDir);
              }
              else {
                AppLogger.logDebug("folder: " + list[i].getName());
                if (!list[i].getName().equalsIgnoreCase("jarsDir")) {
                  filenames.add(list[i].getName());
                  File src = new File(jarsDir + "/" + list[i].getName());
                  if (!src.exists()) {
                    src.mkdir();
                  }
                  String des1 = jarsDir + "/" + list[i].getName();
                  String src1 = path + "/" + list[i].getName();
                  copyFiles(src1, des1);
                }
              }
            }
            catch (Exception e) {
              AppLogger.logError(e.getMessage());
              e.printStackTrace();
            }
          }

          startProcessing(jarsDir, filenames);

        }
        catch (IOException e) {
          AppLogger.logError(e.getMessage());
          JOptionPane.showMessageDialog(null, "An error occurred while installing plugin. Please see log file.");
          e.printStackTrace();
          System.exit(0);
        }
      }
    });
    cancel = new JButton("Cancel");
    cancel.setBounds(430, 330, 80, 30);
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    container = getContentPane();
    container.add(username);
    container.add(usernameInput);
    container.add(password);
    container.add(passwordInput);
    container.add(jarsDir);
    container.add(jarsDirInput);
    container.add(jarsDirLike);
    container.add(websphereHomeDir);
    container.add(websphereHomeDirInput);
    container.add(websphereHomeDir);
    container.add(websphereHomeDirlike);
    container.add(websphereHomeDirInput);
    container.add(websphereDeplMgr);
    container.add(websphereDeplMgrInput);
    container.add(WebSphereApplicationServer);
    container.add(WebSphereApplicationServerInput);
    container.add(singleAndClusterVar);
    container.add(sharedLibraryNameVar);
    container.add(sharedLibraryNameVarInput);
    container.add(description);
    container.add(descriptions);
    container.add(descriptionLineThree);
    container.add(btnBrowse);
    container.add(btnBrowsedir);
    container.add(button1);
    container.add(button2);
    container.add(cancel);
    container.add(submit);

    setBounds(180, 330, 650, 420);
    setVisible(true);
  }

  /**
   * @param args
   * @throws IOException
   */
  @SuppressWarnings("unused")
  public static void main(String[] args) throws IOException {

    FileUtils fileUtils = new FileUtils();
    WebSphereSharedLibManager pluginInstallation = new WebSphereSharedLibManager();

  }

  private void startProcessing(String jarsDir, ArrayList<String> filenames) throws IOException {
    String WASDir = userinput.getWebsphereHomeDir().substring(0, 2);

    String WASBin = WASDir + " \"" + userinput.getWebsphereHomeDir() + "/profiles/" + userinput.getWebsphereDeplMgrprofileName()
        + "/bin\"";

    String pathOfLibrairies = "c:/"; // change to yours
    AppLogger.logDebug("pathOfLibrairies: " + pathOfLibrairies);

    Map<String, String> jarFileNames = new HashMap<String, String>();
    for (int i = 0; i < filenames.size(); i++) {
      String source = jarsDir + "/" + filenames.get(i);

      boolean found = validatePaths(source + "/jars");
      if (found) {
        copyFiles(source + "/jars", pathOfLibrairies + "/plugins/jars");
        jarFileNames = readFileNames(source + "/jars", pathOfLibrairies + "/plugins/jars/", jarFileNames);
      }
    }
    
    manageSharedLibrary(WASBin, jarFileNames);
    FileUtils.deleteDirectory(new File(jarsDir));
    System.exit(0);
  }

  private Map<String, String> readFileNames(String srcPath, String path, Map<String, String> jarFileNames) {
    AppLogger.logDebug("Reading files from " + srcPath);
    File rep = new File(srcPath);
    File[] list = rep.listFiles();

    for (int i = 0; i < list.length; i++) {
      AppLogger.logDebug(path + list[i].getName());
      jarFileNames.put(path + list[i].getName(), "");
    }
    AppLogger.logDebug(jarFileNames.toString());
    return (jarFileNames);
  }

  private void mergeResourceFiles(String srcPath, String descPath) throws IOException {
    AppLogger.logDebug("Merging resource files from " + srcPath);
    File src = new File(srcPath);
    File desc = new File(descPath);

    List<String> lines;
    lines = FileUtils.readLines(src, "utf-8");

    List<String> rlist = new ArrayList<String>();
    String text = FileUtils.readFileToString(desc.getAbsoluteFile());
    for (int i = 0; i < lines.size(); i++) {
      if (!text.contains(lines.get(i))) {
        rlist.add(lines.get(i));
        AppLogger.logDebug("Merging resource: " + lines.get(i));
      }
    }
    AppLogger.logInfo("------------------------------------------------");
    FileUtils.writeLines(desc, rlist, true);
  }

  private void copyFiles(String srcPath, String pathOfLibrairies) throws IOException {
    AppLogger.logInfo("Copying files from your folder (" + srcPath + ") to shared lib configuration folder (" + pathOfLibrairies + ")");

    File source = new File(srcPath);
    File desc = new File(pathOfLibrairies);
    FileUtils.copyDirectory(source, desc);
  }

  private void manageSharedLibrary(String WASBin, Map<String, String> jarFileNames) throws IOException {
    AppLogger.logInfo("Managing shared library...");

    for (String jarName : jarFileNames.keySet()) {
      AppLogger.logDebug("Adding jar: " + jarName);
      String paramsForSharedLib = WASBin + " \"" + userinput.getSharedLibraryName() + "\" \"" + jarName + "\"";
      String clusterName = userinput.getClusterName(); // e.g. "ITIM_Application_Cluster"
      String paramForCluster = paramsForSharedLib + " " + clusterName + "" + " " + userinput.getAdmin() + " "
          + userinput.getPassword() + "";

      Process libProcess = null;
      if (userinput.getSingleAndClusterVar().equalsIgnoreCase("1")) {
        paramsForSharedLib = paramsForSharedLib + " " + userinput.getAdmin() + " " + userinput.getPassword() + "";
        AppLogger.logInfo("Single server option selected");
        // AppLogger.logDebug("Shared library parameters: " + paramsForSharedLib + ", calling  'singleServerSharedLib.bat'");
        libProcess = rt.exec(new String[] { "cmd.exe", "/c", "singleServerSharedLib.bat " + paramsForSharedLib + " " });
      }
      else if (userinput.getSingleAndClusterVar().equalsIgnoreCase("2")) {
        AppLogger.logInfo("Cluster environment option selected");
        // AppLogger.logDebug("Shared library parameters: " + paramForCluster + ", calling  'clusterSharedLib.bat'");
        libProcess = rt.exec(new String[] { "cmd.exe", "/c", "clusterSharedLib.bat " + paramForCluster + " " });
      }

      if (libProcess != null) {
        AppLogger.logInfo("Adding the shared library.");
        
      }
      else {
        AppLogger.logInfo("Shared lib adding process returns null.");
      }
    }

    AppLogger.logInfo("Required libraries addedd successfully");
  }

  private static boolean validatePaths(String Path) {
    File file = new File(Path);

    if (file.isDirectory()) {
      return true;
    }
    return false;

  }

  private static void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(null, '"' + message + '"' + " is not the valid .");
    System.exit(0);
  }

}
