import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String linha = sc.nextLine();

        String[] partes = linha.split(" ");
        String autor = partes[0];
        String conteudo = partes[1];

        Post post = new Post(autor, conteudo);

        int interacoes = sc.nextInt();
        int menu;
        for (int i = 0; i < interacoes; i++) {
            menu = sc.nextInt();

            if (menu == 1) {
                post.like();
            } else {
                post.dislike();
            }
        }

        System.out.printf("%s\n", post.get_conteudo());
        System.out.printf("%s\n", post.get_autor());
        System.out.printf("%d\n", post.n_likes());
        System.out.printf("%d\n", post.n_dislikes());
        System.out.printf("%d\n", post.sentimento());

        sc.close();
    }
}
