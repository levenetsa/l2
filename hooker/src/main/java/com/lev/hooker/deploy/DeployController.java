package com.lev.hooker.deploy;

import com.lev.hooker.utils.ProcessRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.*;

@RestController
public class DeployController {

    @Autowired
    private DeployProperties properties;

    @PostMapping("/deploy")
    public String deploy(@RequestBody byte[] data) throws IOException, InterruptedException {
        File file = prepareDiffFile();
        String diff = decodeDiff(data);
        writeDiffToFile(diff, file);
        execScript(properties.getResetScript());
        execScript(properties.getPullScript());
        execScript(properties.getApplyScript());
        return "Successfully deployed!";
    }


    private void execScript(String name) throws IOException, InterruptedException {
        ProcessRunner.run(name);
    }

    private void writeDiffToFile(String diff, File file) throws IOException {
        try (OutputStream outStream = new FileOutputStream(file)) {
            outStream.write(diff.getBytes());
        }
    }

    private String decodeDiff(byte[] data) {
        String encodedDiff = new String(data);
        String diff = UriEncoder.decode(encodedDiff);
        // Curl append equals sign at the end so ¯\_(ツ)_/¯
        return diff.substring(0, diff.length() - 1) + '\n';
    }

    private File prepareDiffFile() throws IOException {
        File file = new File(properties.getPathToDiff());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

}
