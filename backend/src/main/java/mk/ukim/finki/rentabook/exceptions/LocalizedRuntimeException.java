package mk.ukim.finki.rentabook.exceptions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.ukim.finki.rentabook.localization.MessageResolver;

import java.util.Objects;

public abstract class LocalizedRuntimeException extends RuntimeException {

    private String localizedMessage;
    private final String[] messageArgs;


    protected LocalizedRuntimeException() {
        super();
        this.messageArgs = null;
    }

    public LocalizedRuntimeException(String... messageArgs) {
        this.messageArgs = messageArgs;
    }

    private String getMessageKey() {
        return this.getClass().getSimpleName();
    }

    public LocalizedRuntimeException resolve(MessageResolver messageResolver) {
        var key = getMessageKey();
        localizedMessage = messageResolver.getLocalizedMessage(key);

        if (messageArgs != null && messageArgs.length > 0) {
            localizedMessage = String.format(localizedMessage, (Object[]) messageArgs);
        }

        return this;
    }

    public <T extends LocalizedRuntimeException> T resolveAsSubtype(MessageResolver messageResolver) {
        return (T) resolve(messageResolver);
    }

    @Override
    public String getMessage() {
        return Objects.requireNonNullElseGet(localizedMessage, this::getMessageKey);
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }

    @JsonSerialize
    public String exceptionType() {
        return getClass().getSimpleName();
    }
}

