package uk.ac.solent.com600.team3.motorcyclerideplanner;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.CheckReturnValue;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

public final class MvcResultAssert extends AbstractAssert<MvcResultAssert, MvcResult> {
    private MvcResultAssert(MvcResult actual) {
        super(actual, MvcResultAssert.class);
    }

    @CheckReturnValue
    public static MvcResultAssert assertThat(MvcResult actual) {
        return new MvcResultAssert(actual);
    }

    @CheckReturnValue
    public static MvcResultAssert assertThat(ResultActions actions) {
        return new MvcResultAssert(actions.andReturn());
    }

    public MvcResultAssert hasStatus(HttpStatus status) {
        isNotNull();
        var actualStatus = actual.getResponse().getStatus();
        if (actualStatus != status.value()) {
            failWithMessage("%nExpecting status:%n  <%s>%nto be:%n  <%s>", HttpStatus.valueOf(actualStatus), status);
        }
        return this;
    }

    public MvcResultAssert hasContent(String content) {
        isNotNull();
        try {
            var actualContent = actual.getResponse().getContentAsString();
            if (!actualContent.equals(content)) {
                failWithMessage("%nExpecting content:%n  <%s>%nto be:%n  <%s>", actualContent, content);
            }
        } catch (UnsupportedEncodingException e) {
            failWithMessage("%nExpecting content to be:%n  <%s>%nbut threw:%n  <%s>", actual, e);
        }
        return this;
    }
}
