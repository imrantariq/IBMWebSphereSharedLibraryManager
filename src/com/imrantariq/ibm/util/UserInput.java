package com.imrantariq.ibm.util;

public class UserInput {

  private String admin;

  private String password;

  private String pluginRootDir;

  private String pluginDir;

  private String websphereHomeDir;

  private String websphereDeplMgrprofileName;

  private String WebSphereServerName;

  private String singleAndClusterVar;

  private String clusterName;

  private String sharedLibraryName;

  public String getAdmin() {
    return admin;
  }

  public void setAdmin(String admin) {
    this.admin = admin;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPluginRootDir() {
    return pluginRootDir;
  }

  public void setPluginRootDir(String pluginRootDir) {
    this.pluginRootDir = pluginRootDir;
  }

  public String getPluginDir() {
    return pluginDir;
  }

  public void setPluginDir(String pluginDir) {
    this.pluginDir = pluginDir;
  }

  public String getWebsphereHomeDir() {
    return websphereHomeDir;
  }

  public void setWebsphereHomeDir(String websphereHomeDir) {
    this.websphereHomeDir = websphereHomeDir;
  }

  public String getWebsphereDeplMgrprofileName() {
    return websphereDeplMgrprofileName;
  }

  public void setWebsphereDeplMgrprofileName(String websphereDeplMgrprofileName) {
    this.websphereDeplMgrprofileName = websphereDeplMgrprofileName;
  }

  public String getWebSphereServerName() {
    return WebSphereServerName;
  }

  public void setWebSphereServerName(String webSphereServerName) {
    WebSphereServerName = webSphereServerName;
  }

  public String getSingleAndClusterVar() {
    return singleAndClusterVar;
  }

  public void setSingleAndClusterVar(String singleAndClusterVar) {
    this.singleAndClusterVar = singleAndClusterVar;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public String getSharedLibraryName() {
    return sharedLibraryName;
  }

  public void setSharedLibraryName(String sharedLibraryName) {
    this.sharedLibraryName = sharedLibraryName;
  }

  @Override
  public String toString() {
    return "UserInput [admin=" + admin + ", password=*******, pluginRootDir=" + pluginRootDir + ", pluginDir=" + pluginDir
        + ", websphereHomeDir=" + websphereHomeDir + ", websphereDeplMgrprofileName=" + websphereDeplMgrprofileName
        + ", WebSphereServerName=" + WebSphereServerName + ", singleAndClusterVar=" + singleAndClusterVar + ", clusterName="
        + clusterName + ", sharedLibraryName=" + sharedLibraryName + "]";
  }

}
