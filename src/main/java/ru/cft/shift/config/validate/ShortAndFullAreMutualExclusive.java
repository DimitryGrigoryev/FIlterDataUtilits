package ru.cft.shift.config.validate;

import com.beust.jcommander.IParametersValidator;
import com.beust.jcommander.ParameterException;

import java.util.Map;

import static java.lang.Boolean.TRUE;

public class ShortAndFullAreMutualExclusive implements IParametersValidator {
    @Override
    public void validate(Map<String, Object> parameters) throws ParameterException {
        if (parameters.get("-s") == TRUE && parameters.get("-f") == TRUE)
            throw new ParameterException("-s and -f are mutually exclusive");
    }
}
