import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AppBloco extends JFrame {
    private JTextField campoTexto;
    private JButton botaoMostrar, botaoLimpar, botaoSair, botaoAlterar, botaoInserir;
    private ArrayList<String> notas;

    public AppBloco() {
        notas = new ArrayList<>(); 

        setTitle("Bloco de Notas");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

     
        JLabel nome = new JLabel("Texto:");
        campoTexto = new JTextField(13);
        botaoMostrar = new JButton("Mostrar");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");
        botaoAlterar = new JButton("Alterar");
        botaoInserir = new JButton("Inserir Nota");

       
        add(nome);
        add(campoTexto);
        add(botaoMostrar);
        add(botaoLimpar);
        add(botaoAlterar);
        add(botaoSair);
        add(botaoInserir);

        configurarBotoes(); 
    }

    private void configurarBotoes() {
        botaoInserir.addActionListener(e -> {
            String texto = campoTexto.getText();
            if (!texto.isEmpty()) {
                notas.add(texto); 
                JOptionPane.showMessageDialog(this, "Nota adicionada com sucesso!");
                campoTexto.setText(""); 
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira uma texto para nota.");
            }
        });

        
        botaoMostrar.addActionListener(e -> {
            if (notas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma nota disponível.");
            } else {
                StringBuilder todasNotas = new StringBuilder();
                for (int i = 0; i < notas.size(); i++) {
                    todasNotas.append((i + 1)).append(". ").append(notas.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(this, "Notas:\n" + todasNotas);
            }
        });

        
        botaoLimpar.addActionListener(e -> campoTexto.setText(""));

        
        botaoAlterar.addActionListener(e -> {
            if (notas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma nota disponível para alterar.");
                return;
            }

            String notaAntiga = JOptionPane.showInputDialog(this, "Digite o número da nota que deseja alterar:");
            if (notaAntiga != null) {
                try {
                    int indice = Integer.parseInt(notaAntiga) - 1;
                    if (indice >= 0 && indice < notas.size()) {
                        String novoTexto = JOptionPane.showInputDialog(this, "Digite uma nova nota:");
                        if (novoTexto != null) {
                            notas.set(indice, novoTexto); 
                            JOptionPane.showMessageDialog(this, "Nota alterada com sucesso");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Número inválido.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Inválido! Digite um número.");
                }
            }
        });

        
        botaoSair.addActionListener(e -> System.exit(0));
    }
    
    public static void main(String[] args) {
        AppBloco app = new AppBloco();
        app.setVisible(true);
    }
}
