package com.ibm.cloud;

public class MainExamples {
    public static void main(String[] args){
        // this is a quick and dirty way to switch between which examples to run.
        switch(args[0]){
            case "instance-policies":
                InstancePoliciesExamples.instancePoliciesExamples();
                break;
            case "key-actions":
                KeyActionsExamples.keyActionsExamples();
                break;
            case "key-alias":
                KeyAliasExample.keyAliasExample();
                break;
            case "key-policies":
                KeyPoliciesExamples.keyPoliciesExamples();
                break;
            case "key-registration":
                KeyRegistrationExamples.keyRegistrationExamples();
                break;
            case "key-ring":
                KeyRingExample.keyRingExample();
                break;
            case "kmip":
                KMIPExample.kmipExamples();
                break;
            case "keys":
            default:
                KeysExamples.keysExample();
                break;
        }
    }
}
