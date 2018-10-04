package com.springsecuritycourse.config.customaccessdecisionvotersconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Dégi János on 2018.03.03..
 *
 * Scenario:
 * Cache for users who sould be immediatly locked out of the system
 *
 */
public final class LockedUsers {
    private static final List<String> lockedUsersSets = new ArrayList<String>();
    private LockedUsers() {}
    public static final boolean isLocked(final String username) {
        return lockedUsersSets.contains(username);
    }
    public static final void lock(final String username) {
        lockedUsersSets.add(username);
    }
}
