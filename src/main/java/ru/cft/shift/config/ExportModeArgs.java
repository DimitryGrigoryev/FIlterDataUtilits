package ru.cft.shift.config;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@FieldDefaults(level = PRIVATE)
public class ExportModeArgs {
    @Parameter(names = "-a", description = "Write method. added or overwriting")
    boolean saveAddingMode = false;

    @Parameter(names = "-o" , description = "outputDirectory")
    String outputDirectory = "export/";

    @Parameter(names = "-p" , description = "prefixName")
    String prefixName = "";

    @Parameter(names = {"--help", "-h"}, description = "Displays information about this application. Ignoring other options", help = true)
    private boolean help;

    @Override
    public String toString() {
        return "ExportModeArgs{" +
                "saveAddingMode=" + saveAddingMode +
                ", outputDirectory='" + outputDirectory + '\'' +
                ", prefixName='" + prefixName + '\'' +
                ", help=" + help +
                '}';
    }
}
