// Tempo para resolver no computador:
// A) 13 minutos
// B) 24 minutos
// C) 17 minutos
// D) 30 minutos
// Total: 84 minutos (1h24)

public class Prova {

    public static final int TAM_MAX = 20;

    // ---------- Funções auxiliares ----------

    // Verifica se x já existe nas primeiras tam posições de v
    public static boolean contem(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i] == x) {
                return true;
            }
        }
        return false;
    }

    // Insere x no fim de v somente se ele ainda não existe; retorna o novo tamanho
    public static int inserirSemRepetir(int[] v, int tam, int x) {
        if (!contem(v, tam, x)) {
            v[tam] = x;
            tam += 1;
        }
        return tam;
    }

    // Rotaciona o vetor uma posição para a esquerda
    public static void rotacionarUmaEsquerda(int[] v, int tam) {
        int primeiro = v[0];
        for (int i = 0; i < tam - 1; i += 1) {
            v[i] = v[i + 1];
        }
        v[tam - 1] = primeiro;
    }

    // Rotaciona o vetor uma posição para a direita
    public static void rotacionarUmaDireita(int[] v, int tam) {
        int ultimo = v[tam - 1];
        for (int i = tam - 1; i > 0; i -= 1) {
            v[i] = v[i - 1];
        }
        v[0] = ultimo;
    }

    public static void imprimir(int[] v, int tam) {
        for (int i = 0; i < tam; i += 1) {
            System.out.print(v[i]);
            if (i < tam - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // ---------- Questões ----------
   
    // a) União sem repetição.
    // 13 minutos
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;
        for (int i = 0; i < tamA; i += 1) {
            tamU = inserirSemRepetir(u, tamU, a[i]);
        }
        for (int i = 0; i < tamB; i += 1) {
            tamU = inserirSemRepetir(u, tamU, b[i]);
        }
        return tamU;
    }
    
    // b) Insertion sort
    // 24 minutos
    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i += 1) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    }

    // c) Vetor sem repetição
    // 17 minutos
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVsr = 0;
        for (int i = 0; i < tamV; i += 1) {
            tamVsr = inserirSemRepetir(vsr, tamVsr, v[i]);
        }
        return tamVsr;
    }

    // d) Rotação in-place
    // 30 minutos
    public static void rotacionar(int[] v, int tam, int k) {
        if (tam > 1) {
            if (k > 0) {
                for (int i = 0; i < k % tam; i += 1) {
                    rotacionarUmaEsquerda(v, tam);
                }
            } else {
                for (int i = 0; i < (-k) % tam; i += 1) {
                    rotacionarUmaDireita(v, tam);
                }
            }
        }
    }

    // ---------- Testes ----------

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        int[] b = {3, 4, 5, 1};
        int[] u = new int[TAM_MAX];
        int tamU = uniao(a, 4, b, 4, u);
        System.out.print("União: ");
        imprimir(u, tamU);

        int[] v = {9, 4, 7, 1, 3};
        ordenar(v, 5);
        System.out.print("Ordenado: ");
        imprimir(v, 5);

        int[] w = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] vsr = new int[TAM_MAX];
        int tamVsr = gerarVetorSemRepeticao(w, 9, vsr);
        System.out.print("Sem repetição: ");
        imprimir(vsr, tamVsr);

        int[] r1 = {1, 2, 3, 4, 5};
        rotacionar(r1, 5, 2);
        System.out.print("k = 2: ");
        imprimir(r1, 5);

        int[] r2 = {1, 2, 3, 4, 5};
        rotacionar(r2, 5, -1);
        System.out.print("k = -1: ");
        imprimir(r2, 5);
    }
}
