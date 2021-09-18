/**
 * 
 */
package vn.tcx.zk.core;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.sys.ValidationMessages;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.SimpleConstraint;
import org.zkoss.zul.mesg.MZul;

import lombok.extern.slf4j.Slf4j;

/**
 * @author caltalys
 *
 */
@Slf4j
public class BaseValidator extends AbstractValidator {

    @Override
    public void validate(ValidationContext ctx) {
        final ValidationMessages vmsgs = (ValidationMessages) ctx.getValidatorArg("vmsg");
        if (vmsgs != null) {
            vmsgs.clearKeyMessages(Throwable.class.getSimpleName());
            vmsgs.clearMessages(ctx.getBindContext().getComponent());
        }
        log.info("validate: " + (validateConstraint(ctx)));
    }

    private boolean validateConstraint(final ValidationContext ctx) {
        boolean result;
        final Object constraint = ctx.getValidatorArg("constraint");
        if (constraint == null) {
            result = true;
        } else {
            try {
                new SimpleConstraint(constraint.toString()).validate(null, ctx.getProperty().getValue());
                result = true;
            } catch (final WrongValueException ex) {
                Object msg;
                Object msgid = ctx.getValidatorArg("msgid");
                if (ex.getCode() == MZul.EMPTY_NOT_ALLOWED) {
                    if (msgid == null) {
                        msg = "Bạn không được để trống trường này.";
                    } else {
                        msg = "Vui lòng nhập!";
                    }
                } else if (ex.getCode() == MZul.NO_TODAY) {
                    msg = "no today";
                } else if (ex.getCode() == MZul.NO_NEGATIVE) {
                    msg = "no negative";
                } else if (ex.getCode() == MZul.NO_POSITIVE) {
                    msg = "no positive";
                } else if (ex.getCode() == MZul.NO_FUTURE) {
                    msg = "Không được lớn hơn ngày hiện tại";
                } else if (ex.getCode() == MZul.NO_ZERO) {
                    msg = "no zero";
                } else if (ex.getCode() == MZul.NO_PAST) {
                    msg = "Không được nhỏ hơn ngày hiện tại";
                } else if (ex.getCode() == MZul.NO_POSITIVE_ZERO) {
                    msg = "NO_POSITIVE_ZERO";
                } else if (ex.getCode() == MZul.NO_POSITIVE_NEGATIVE_ZERO) {
                    msg = "NO_POSITIVE_NEGATIVE_ZERO";
                } else if (ex.getCode() == MZul.NO_POSITIVE_NEGATIVE) {
                    msg = "NO_POSITIVE_NEGATIVE";
                } else if (ex.getCode() == MZul.NO_FUTURE_TODAY) {
                    msg = "NO_FUTURE_TODAY";
                } else if (ex.getCode() == MZul.NO_PAST_TODAY) {
                    msg = "NO_PAST_TODAY";
                } else if (ex.getCode() == MZul.NO_FUTURE_PAST_TODAY) {
                    msg = "NO_FUTURE_PAST_TODAY";
                } else if (ex.getCode() == MZul.NO_FUTURE_PAST) {
                    msg = "NO_FUTURE_PAST";
                } else if (ex.getCode() == MZul.VALUE_NOT_MATCHED) {
                    msg = "VALUE_NOT_MATCHED";
                } else if (ctx.getValidatorArg("cmsg") == null) {
                    msg = ex.getMessage();
                } else {
                    msg = ctx.getValidatorArg("cmsg");
                }
                log.info(ctx.getBindContext().getComponent() + "");
                log.info(ctx.getBindContext().getComponent().getId() + "");
                if (msgid == null) {
                    addInvalidMessage(ctx, msg.toString());
                } else {
                    addInvalidMessage(ctx, msgid.toString(), msg.toString());
                }
                result = false;
            }
        }
        return result;
    }
}
