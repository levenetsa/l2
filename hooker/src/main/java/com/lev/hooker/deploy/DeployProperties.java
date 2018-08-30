package com.lev.hooker.deploy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("deploy")
public class DeployProperties {

    private String resetScript;
    private String pullScript;
    private String applyScript;
    private String pathToDiff;

    public String getResetScript() {
        return resetScript;
    }

    public void setResetScript(String resetScript) {
        this.resetScript = resetScript;
    }

    public String getPullScript() {
        return pullScript;
    }

    public void setPullScript(String pullScript) {
        this.pullScript = pullScript;
    }

    public String getApplyScript() {
        return applyScript;
    }

    public void setApplyScript(String applyScript) {
        this.applyScript = applyScript;
    }

    public String getPathToDiff() {
        return pathToDiff;
    }

    public void setPathToDiff(String pathToDiff) {
        this.pathToDiff = pathToDiff;
    }
}
