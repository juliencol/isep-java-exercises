import java.util.*;

public class Main {
	static ArrayList<Integer> liste = new ArrayList<>();
    static HashMap<String, ArrayList<String>> reseau = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static int userChoice;
    static String userName;
    static String firstUserName;
    static String secondUserName;
    
	public static void main(String[] args) {
		// Testing isAnagram (2.1.1)
		System.out.println(isAnagram("engager", " ")); // false
		System.out.println(isAnagram("engage", "bonjour")); // false
		System.out.println(isAnagram("engager", "regagne")); // true
		System.out.println(isAnagram("engager", "rengage")); // true
		System.out.println(isAnagram("regagne", "rengage")); // true
		
		// Testing isAnagramRec (2.1.2)
		System.out.println(isAnagramRec("engager", " ")); // false
		System.out.println(isAnagramRec("engage", "bonjour")); // false
		System.out.println(isAnagramRec("engager", "regagne")); // true
		System.out.println(isAnagramRec("engager", "rengage")); // true
		System.out.println(isAnagramRec("regagne", "rengage")); // true
		
		// Testing triListe (2.2)
		ArrayList<Integer> testingList = new ArrayList<Integer>();
		testingList.add(4);
		testingList.add(-2);
		testingList.add(31);
		testingList.add(-5);
		testingList.add(12);
		System.out.println(triListe(testingList)); // [−2, 4, 12, −5, 31]
		
		// Runing réseau social
		while (userChoice != 0) {
			System.out.println("Voici les utilisateurs du réseau social");
			System.out.println(reseau);
			menu();
			switch (userChoice) {
	        	case 1:
	        		ajoutUtilisateur();
	                break;
	        	case 2:
	        		suivreUtilisateur();
	        		break;
	        	case 3:
	        		listerUtilisateurs();
	        		break;
	        	case 4:
	        		listerUtilisateursSuivis();
	        		break;
	        	case 5:
	        		listerUtilisateursSuiveurs();
	        		break;
	        	case 6:
	        		arreterSuivi();
	        		break;
	        	case 7:
	        		supprimerUtilisateur();
	        		break;
	            default:
	            	System.out.println("Entrez un nombre entre 1 et 7");
			}
		}
	}
	
	// 2.1 Détection d'anagrames
	// 2.1.1 Fonction itérative
	public static boolean isAnagram(String s1, String s2) {
		/* This function tells us if two strings are anagrams or not, wrote iteratively. 
		 * Time complexity : O(n) */
		if(s1.length() != s2.length()) {
			return false;
		}
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] s1Array = s1.toCharArray(); 
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array); 
        Arrays.sort(s2Array); 
        for(int i = 0; i < s1Array.length; i++) {
        	if(s1Array[i] != s2Array[i]) {
        		return false;
            }
        }
        return true;
	}
	
	// 2.1.2 Fonction récursive
	public static boolean isAnagramRec(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		// base case
		if(s1.equals("") || s2.equals("")) {
			return false;
		}
		
		// recursive call
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        String s1FirstLetter = String.valueOf(s1Array[0]);
        String s2FirstLetter = String.valueOf(s2Array[0]);
        if (s1FirstLetter.equals(s2FirstLetter)) {
        	s1 = s1.replaceFirst(s1FirstLetter, "");
            s2 = s2.replaceFirst(s2FirstLetter, "");
            isAnagramRec(s1, s2);
         } 
        return true;
    }
	
	// 2.2 Tri d'une liste
	public static ArrayList triListe(ArrayList<Integer>liste) {
		/* This function sorts a list, separating even and odd elements. */
		
		// divide the list into two sublists
		ArrayList<Integer> evenSubList = new ArrayList<Integer>();
        ArrayList<Integer> oddSubList = new ArrayList<Integer>();
		for(int i = 0; i < liste.size(); i++) {
			if(liste.get(i) % 2 == 0) {
				evenSubList.add(liste.get(i));
			}
			else {
				oddSubList.add(liste.get(i));
			}	
		}
		
		// sort the sublists
		Collections.sort(evenSubList);  
        Collections.sort(oddSubList);
        
        // concatenate them
        for(int i = 0; i < evenSubList.size(); i++) { 
            liste.set(i, evenSubList.get(i));
        }
        for(int i = 0; i < oddSubList.size(); i++) {  
            liste.set(i + evenSubList.size(), oddSubList.get(i));
        }
        return liste;
	}
	
	// 2.3 Réseau social
	// 2.3.1 Menu de l'exercice
	public static void menu() {
        System.out.println("Bienvenue dans votre réseau social ! \n" +
        "Tapez 1 pour ajouter un utilisateur à votre réseau social. \n" +
        "Tapez 2 pour suivre un autre utilisateur. \n" +
        "Tapez 3 pour lister tous les utilisateurs du réseau social. \n" +
        "Tapez 4 pour lister tous les utilisateurs suivis par un utilisateur donné. \n" +
        "Tapez 5 pour lister tous les utilisateurs qui suivent un utilisateur donné. \n" +
        "Tapez 6 pour arrêter de suivre un utilisateur pour un utilisateur donné. \n" +
        "Tapez 7 pour supprimer un utilisateur du réseau social. \n" +
        "Tapez 0 pour quitter.");
        userChoice = scanner.nextInt();
    }
	
	// 2.3.2 Ajouter un utilisateur au réseau social
	public static void ajoutUtilisateur() {
		// Demande la saisie du nom d’un utilisateur 
		System.out.println("Entree votre nom d'utilisateur : \n");
		userName = scanner.next();
		ArrayList<String> newUser = new ArrayList<>();
		
		// Si cet utilisateur est déjà présent sur le réseau social, affiche un messaged’erreur ;
		 if(reseau.containsKey(userName)) {
			 System.out.println("Erreur : vous faites déjà parti du réseau social.");
	     }
		 
		 // Si cet utilisateur n’est pas déjà présent, l’ajoute au réseau social
		 else {
			 reseau.put(userName, newUser);
	     }
	}
	
	// 2.3.3 Suivre un autre utilisateur
	public static void suivreUtilisateur() {
		// Demande la saisie du nom d’un premier utilisateur ;
		System.out.println("Entree votre nom d'utilisateur : \n");
		firstUserName = scanner.next();
		
		//Demande la saisie du nom d’un second utilisateur ;
		System.out.println("Entree le nom de l'utilisateur que vous souhaitez suivre : \n");
		secondUserName = scanner.next();
		
		ArrayList<String> firstUser = new ArrayList<>();
        ArrayList<String> secondUser = new ArrayList<>();
        
        // Si les deux utilisateurs sont inscrits sur le réseau social :
		if(reseau.containsKey(firstUserName) && reseau.containsKey(secondUserName)) {
			for(int i = 0; i < firstUser.size(); i++) {
				// check si le premier user suit le second
				if(firstUser.get(i).equals(secondUser)) {
					// i le premier utilisateur suit déjà le second utilisateur, affiche un mes-sage d’erreur 
					System.out.println("Erreur: vous suivez déjà cet utilisateur.");
				}
				// Sinon, crée cette relation de suivi entre le premier utilisateur et lesecond utilisateur
				else {
					firstUser.add(secondUserName);
				}
			}
	    }
		
		// Sinon, inscrit les deux utilisateurs et crée la relation de suivi décrite juste au-dessus.
		else {
			// inscrit les deux utilisateurs et crée la relation de suivie
			reseau.put(firstUserName, firstUser);
			reseau.put(secondUserName, secondUser);
		}
	}
	
	// 2.3.4 Lister tous les utilisateurs du réseau social
	public static void listerUtilisateurs() {
		System.out.println("Liste des utilisateurs :");
        ArrayList<String> usersSorted = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> user : reseau.entrySet()) {
            usersSorted.add(user.getKey().toLowerCase());
        }
        Collections.sort(usersSorted);
        System.out.println(usersSorted);
	}
	
	// 2.3.5 Lister tous les utilisateurs suivis
	public static void listerUtilisateursSuivis() {
		// Demande la saisie du nom d’un utilisateur
		System.out.println("Entrer votre nom d'utilisateur :");
		userName = scanner.next();
		
		ArrayList<String> userFollowers = reseau.get(userName);
		Collections.sort(userFollowers);  
		
		// Si cet utilisateur n’est pas sur le réseau social, affiche un message d’erreur
		if(!reseau.containsKey(userName)) {
			System.out.println("Erreur : vous n'êtes pas sur le réseau.");
		}
		
		// Si cet utilisateur est sur le réseau social, affiche la liste des utilisateursqu’il suit, classés par ordre alphabétiqu
		else {
            if(userFollowers.size() == 0) {
                System.out.println(userName + "ne suit personne.");
            }
            else {
                System.out.println(userName + "suit : " + userFollowers);
            }
		}
	}
	
	// 2.3.6 Lister tous mes suiveurs
	public static void listerUtilisateursSuiveurs() {
		// Demande la saisie du nom d’un utilisateur
		System.out.println("Entrer votre nom d'utilisateur :");
		userName = scanner.next();
		ArrayList<String> userFollowers = reseau.get(userName);
		
		// Si cet utilisateur n’est pas sur le réseau social, affiche un message d’erreur
		if(!reseau.containsKey(userName)) {
			System.out.println("Erreur : vous n'êtes pas sur le réseau.");
		}
		
		// Si cet utilisateur est sur le réseau social, affiche la liste de tous les autresutilisateurs qui le suivent, classés par ordre alphabétique
		else {
            if(userFollowers.size() == 0) {
                System.out.println("Personne ne vous suit.");
            }
            else {
                System.out.println("Les utilisateurs qui suivent " + userName + " sont " + userFollowers);
            }
		}
	}
	
	// 2.3.7
	public static void arreterSuivi() {
		// Demande la saisie du nom d’un premier utilisateur 
		System.out.println("Entrez votre nom d'utilisateur : ");
        userName = scanner.nextLine();
        
        // Demande la saisie du nom d’un second utilisateur 
        System.out.println("Entre le nom de l'utilisateur que vous souhaitez arrêter de suivre : ");
        secondUserName = scanner.nextLine();
        
        ArrayList<String> userFollowers = new ArrayList<>();
        userFollowers = reseau.get(userName);
        
        for(int i = 0; i < userFollowers.size(); i++) {
        	if (userFollowers.get(i) == secondUserName) {
        		userFollowers.remove(i);
        	}
        	else {
        		// // Si le premier utilisateur ne suit pas le second utilisateur, affiche un mes-sage d’erreur
        		System.out.println("Erreur : l'utilisateur que vous avez saisi n'existe pas sur le réseau.");
        	}
           }
        }
	
	
	// 2.3.8
	public static void supprimerUtilisateur() {
		// Demande la saisie du nom d’un utilisateur 
        System.out.println("Entrez votre nom d'utilisateur :");
        userName = scanner.nextLine();
        
        // si cet utilisateur est inscrit sur le réseau social, le supprime du réseau ;
        if(reseau.containsKey(userName)) {
        	reseau.remove(userName);
        	System.out.println("Vous avez bien été supprimé du réseau social.");
        }
        
        // Sinon, affiche un message d’erreur.
        else {
        	System.out.println("Erreur : vous ne faites pas parti du réseau social.");
        }
    }
	
}
