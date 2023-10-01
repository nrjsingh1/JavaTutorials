package Reflection;

public enum Role {

    MANAGER("manager"),
    DEVELOPER("developer"),
    DEVOPS("devops"),
    TESTER("tester");

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    Role(final String value){this.value = value;}

    public String getValue(){return value; }

    public static Role getRoleFromValue(String value){
        for(Role role : Role.values()){
            if(role.getValue().equals(value))
                return role;
        }
        return null;
    }
}
