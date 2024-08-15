package LaksSecurity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthorizationModule {

    private static final Map<String, Set<String>> rolePermissions = new HashMap<>();

    static {
        rolePermissions.put("ADMIN", Set.of("CREATE_USER", "DELETE_USER"));
        rolePermissions.put("USER", Set.of("READ_PROFILE"));
    }

    public static boolean hasPermission(String role, String permission) {
        Set<String> permissions = rolePermissions.getOrDefault(role, Set.of());
        return permissions.contains(permission);
    }

    public static Set<String> getAllRoles() {
        return rolePermissions.keySet();
    }

    public static Set<String> getPermissionsByRole(String role) {
        return rolePermissions.getOrDefault(role, Set.of());
    }
}