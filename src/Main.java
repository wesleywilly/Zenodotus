/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import WebCrawlers.Zenodotus;
import Utilities.FileUtilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class Main {

    
    public static final String GET_CATEGORIES_LIST = "-gcl";
    public static final String GET_RELATIONS_LIST = "-grl";

    public static final String GET_RELATION = "-gr";
    public static final String GET_CATEGORY = "-gc";
    public static final String GET_CATEGORY_INSTANCE = "-gci";

    public static final String SEARCH_CATEGORY = "-sc";
    public static final String SEARCH_RELATION = "-sr";
    public static final String SEARCH_CATEGORY_INSTANCE = "-sci";

    public static final String SAVE = "-s";

    public static void main(String[] args) {

        Zenodotus z = new Zenodotus();

        if (args.length > 0) {

            System.out.println("[MAIN] Searching...");
            

            if (args[0].equals(GET_CATEGORIES_LIST)) {
                JSONArray x = new JSONArray();
                x = z.getCategoriesList();
                System.out.println("[MAIN] search completed.");
                if (args.length > 1) {
                    if (args[1].equals(SAVE)) {
                        System.out.println("[MAIN] Saving...");
                        JSONObject result = new JSONObject();
                        result.put("categories_list", x);
                        FileUtilities.save(result, args[2]);
                    } else {
                        System.out.println("[MAIN] Incompatible parameter! \"" + args[1] + "\"");
                        System.out.println(x);
                    }
                } else {
                    System.out.println(x);
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(GET_RELATIONS_LIST)) {
                JSONArray x = new JSONArray();
                x = z.getRelationsList();
                System.out.println("[MAIN] search completed.");
                if (args.length > 1) {
                    if (args[1].equals(SAVE)) {
                        System.out.println("[MAIN] Saving...");
                        JSONObject result = new JSONObject();
                        result.put("relations_list", x);
                        FileUtilities.save(result, args[2]);
                    } else {
                        System.out.println("[MAIN] Incompatible parameter! \"" + args[1] + "\", expected <file url>");
                        System.out.println(x);
                    }
                } else {
                    System.out.println(x);
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(GET_CATEGORY)) {
                JSONObject x = new JSONObject();
                if (args.length > 1) {
                    x = z.getCategory(args[1]);
                    System.out.println("[MAIN] search completed.");
                    if (args.length > 2) {
                        if (args[2].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            FileUtilities.save(x, args[3]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[2] + "\", expected <file url>");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                } else {
                    System.out.println("[MAIN] Insufficient parameters! \"" + args[0] + "\", expected: <category predicate>");
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(GET_RELATION)) {
                JSONObject x = new JSONObject();
                if (args.length > 1) {
                    x = z.getRelation(args[1]);
                    System.out.println("[MAIN] search completed.");
                    if (args.length > 2) {
                        if (args[2].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            FileUtilities.save(x, args[3]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[2] + "\", expected <file url>");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                } else {
                    System.out.println("[MAIN] Insufficient parameters! \"" + args[0] + "\", expected: <category predicate>");
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(GET_CATEGORY_INSTANCE)) {
                JSONObject x = new JSONObject();
                if (args.length > 2) {
                    x = z.getCategoryInstance(args[1], args[2]);
                    System.out.println("[MAIN] search completed.");
                    if (args.length > 3) {
                        if (args[3].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            FileUtilities.save(x, args[4]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[3] + "\", expected <file url>");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                } else {
                    System.out.println("[MAIN] Insufficient parameters! \"" + args[1] + " or " + args[2] + "\", expected: <category predicate> <instance name>");
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(SEARCH_CATEGORY)) {
                JSONArray x = new JSONArray();
                if (args.length > 1) {
                    System.out.println("[MAIN] It may take a while.");
                    x = z.searchCategory(args[1]);
                    System.out.println("[MAIN] search completed.");
                    if (args.length > 2) {
                        if (args[2].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            JSONObject result = new JSONObject();
                            result.put("categories_founded", x);
                            FileUtilities.save(result, args[3]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[2] + "\"");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(SEARCH_RELATION)) {
                JSONArray x = new JSONArray();
                if (args.length > 1) {
                    System.out.println("[MAIN] It may take a while.");
                    x = z.searchRelation(args[1]);
                    System.out.println("[MAIN] search completed.");
                    if (args.length > 2) {
                        if (args[2].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            JSONObject result = new JSONObject();
                            result.put("relations_founded", x);
                            FileUtilities.save(result, args[3]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[2] + "\"");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                }
                System.out.println("[MAIN] Finished.");
            } else if (args[0].equals(SEARCH_CATEGORY_INSTANCE)) {
                int index=1;
                JSONArray x = new JSONArray();
                if (args.length > index) {
                    
                    if (args.length > 2 && !args[2].equals(SAVE)) {
                        System.out.println("[MAIN] It may take a long time!");
                        x = z.searchCategoryInstance(args[1], args[2]);
                        index+=2;
                    } else {
                        System.out.println("[MAIN] Well, I'll look for it in the whole NeLL's knowledge base! I hope you have something else to do...");
                        x = z.searchCategoryInstance(args[1]);
                        index++;
                    }
                    System.out.println("[MAIN] search completed.");
                    if (args.length > index) {
                        if (args[index].equals(SAVE)) {
                            System.out.println("[MAIN] Saving...");
                            JSONObject result = new JSONObject();
                            result.put("instances_founded", x);
                            index++;
                            FileUtilities.save(result, args[index]);
                        } else {
                            System.out.println("[MAIN] Incompatible parameter! \"" + args[index] + "\"");
                            System.out.println(x);
                        }
                    } else {
                        System.out.println(x);
                    }
                }
                System.out.println("[MAIN] Finished.");
            } else{
                System.out.println("[MAIN] Incompatible parameter! \"" + args[0] + "\"");
                help();
            }
        } else {
            help();
        }

    }

    public static void help() {
        System.out.println("===== HELP =====");
        System.out.println("");
        System.out.println(GET_CATEGORIES_LIST + "\t=> Return Categories list [JSONArray]");
        System.out.println(GET_RELATIONS_LIST + "\t=> Return relations list [JSONArray]");
        System.out.println("");
        System.out.println(GET_CATEGORY + " <predicate>\t=> Return a category by predicate. [JSONObject]");
        System.out.println(GET_RELATION + " <predicate>\t=> Return a relation by predicate. [JSONObject]");
        System.out.println(GET_CATEGORY_INSTANCE + " <category predicate> <instance name>\t=> Return a category instance. [JSONObject]");
        System.out.println("");
        System.out.println(SEARCH_CATEGORY + " <keyword>\t=> Return a list of categories. [JSONArray]");
        System.out.println(SEARCH_RELATION + " <keyword>\t=> Return a list of relations. [JSONArray]");
        System.out.println(SEARCH_CATEGORY_INSTANCE + " <keyword>\t=> Return a list of category instances. [JSONArray]");
        System.out.println(SEARCH_CATEGORY_INSTANCE + " <category predicate> <keyword>\t=> Return a list of instances from a especific category. [JSONArray]");
        System.out.println("");
        System.out.println(SAVE + " <file url>\t=> Save the results in a text file [JSONOBject]");

    }

}
