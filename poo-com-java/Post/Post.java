public class Post {
    private String autor;
    private String conteudo;
    private int likes;
    private int dislikes;

    public Post(String autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.likes = 0;
        this.dislikes = 0;
    }

    public void like() {
        this.likes++;
    }

    public void dislike() {
        this.dislikes++;
    }

    public String get_autor() {
        return this.autor;
    }

    public String get_conteudo() {
        return this.conteudo;
    }

    public int n_likes() {
        return this.likes;
    }

    public int n_dislikes() {
        return this.dislikes;
    }

    public int sentimento() {
        if (this.dislikes > this.likes) {
            return 0;
        }
        return 1;
    }
}
