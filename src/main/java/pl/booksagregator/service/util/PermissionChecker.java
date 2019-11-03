package pl.booksagregator.service.util;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.booksagregator.exception.ApiRequestForbiddenException;

public class PermissionChecker {

    private PermissionChecker() {}

    public static void checkPermission(String username) {
        String authorizedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals(authorizedUser)) {
            throw new ApiRequestForbiddenException("Not authorized to this resource");
        }
    }


    public static void checkPermission(String username, boolean open) {
        String authorizedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals(authorizedUser) && !open) {
            throw new ApiRequestForbiddenException("Not authorized to this resource");
        }
    }

}
