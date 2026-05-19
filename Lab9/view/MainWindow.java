package Lab9.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;

import Lab9.model.Equipment;
import Lab9.model.Request;

public class MainWindow extends VBox {
    
    // Componentes da interface
    private ComboBox<String> userTypeComboBox;
    private ComboBox<Equipment> equipmentComboBox;
    private TextField nameTextField;
    private TextArea descriptionTextArea;
    private TextField otherEquipmentTextField;
    private Button addEquipmentButton;
    
    // Lista de equipamentos
    private List<Equipment> equipments;
    
    public MainWindow() {
        // Inicializar lista de equipamentos (Nível 2)
        initializeEquipmentList();
        
        // Criar a interface principal
        VBox root = createMainLayout();
        
        // Copiar propriedades do root para este VBox
        this.setSpacing(root.getSpacing());
        this.setPadding(root.getPadding());
        this.setStyle(root.getStyle());
        this.getChildren().addAll(root.getChildren());
    }
    
    /**
     * Inicializa a lista de equipamentos com os equipamentos padrão
     * Nível 2 - Criar lista de equipamentos
     */
    private void initializeEquipmentList() {
        equipments = new ArrayList<>();
        equipments.add(new Equipment("Computer (Hardware)", "Hardware"));
        equipments.add(new Equipment("Impressora", "Hardware"));
        equipments.add(new Equipment("Rede Wi-Fi", "Rede"));
        equipments.add(new Equipment("Moodle", "Software"));
        equipments.add(new Equipment("Email Institucional", "Software"));
        equipments.add(new Equipment("Other Equipment", "Other")); // Nível 5
    }
    
    /**
     * Cria o layout principal da aplicação
     * Nível 1 - Árvore de nós implementada
     */
    private VBox createMainLayout() {
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));
        mainLayout.setStyle("-fx-background-color: #f0f0f0;");
        
        // MenuBar (Nível 4)
        MenuBar menuBar = createMenuBar();
        
        // Título
        Label titleLabel = new Label("Gestão de Pedidos de Apoio Técnico");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        // Secção: Tipo de utilizador
        VBox userTypeSection = createUserTypeSection();
        
        // Secção: Equipamento / Serviço
        VBox equipmentSection = createEquipmentSection();
        
        // Secção: Dados do utilizador
        VBox userDataSection = createUserDataSection();
        
        // Secção: Botões de ação
        HBox buttonSection = createButtonSection();
        
        // Adicionar todas as secções ao layout principal
        mainLayout.getChildren().addAll(
            menuBar,
            titleLabel,
            new Separator(),
            userTypeSection,
            equipmentSection,
            userDataSection,
            buttonSection
        );
        
        return mainLayout;
    }
    
    /**
     * Cria a secção do tipo de utilizador
     */
    private VBox createUserTypeSection() {
        VBox section = new VBox(5);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5;");
        
        Label sectionLabel = new Label("Tipo de utilizador");
        sectionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        userTypeComboBox = new ComboBox<>();
        userTypeComboBox.getItems().addAll("Estudante", "Docente", "Funcionário");
        userTypeComboBox.setValue("Estudante");
        userTypeComboBox.setStyle("-fx-pref-width: 200px;");
        
        section.getChildren().addAll(sectionLabel, userTypeComboBox);
        return section;
    }
    
    /**
     * Cria a secção de equipamento (Nível 5 - ComboBox com Other Equipment)
     */
    private VBox createEquipmentSection() {
        VBox section = new VBox(5);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5;");
        
        Label sectionLabel = new Label("Equipamento / Serviço");
        sectionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        Label instructionLabel = new Label("Selecione o equipamento ou serviço:");
        instructionLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");
        
        // ComboBox de equipamentos
        equipmentComboBox = new ComboBox<>();
        equipmentComboBox.getItems().addAll(equipments);
        equipmentComboBox.setValue(equipments.get(0));
        equipmentComboBox.setStyle("-fx-pref-width: 300px;");
        
        // Campo para novo equipamento (inicialmente invisível)
        otherEquipmentTextField = new TextField();
        otherEquipmentTextField.setPromptText("Digite o nome do novo equipamento...");
        otherEquipmentTextField.setVisible(false);
        otherEquipmentTextField.setManaged(false);
        otherEquipmentTextField.setStyle("-fx-pref-width: 300px; -fx-padding: 5;");
        
        // Botão para adicionar novo equipamento
        addEquipmentButton = new Button("Adicionar Equipamento");
        addEquipmentButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-padding: 5 15;");
        addEquipmentButton.setOnAction(e -> addNewEquipment());
        addEquipmentButton.setVisible(false);
        addEquipmentButton.setManaged(false);
        
        // Listener para mostrar/esconder o campo de novo equipamento
        equipmentComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && newVal.getName().equals("Other Equipment")) {
                otherEquipmentTextField.setVisible(true);
                otherEquipmentTextField.setManaged(true);
                addEquipmentButton.setVisible(true);
                addEquipmentButton.setManaged(true);
            } else {
                otherEquipmentTextField.setVisible(false);
                otherEquipmentTextField.setManaged(false);
                addEquipmentButton.setVisible(false);
                addEquipmentButton.setManaged(false);
            }
        });
        
        HBox equipmentBox = new HBox(10);
        equipmentBox.getChildren().addAll(equipmentComboBox);
        
        section.getChildren().addAll(sectionLabel, instructionLabel, equipmentBox, otherEquipmentTextField, addEquipmentButton);
        return section;
    }
    
    /**
     * Cria a secção de dados do utilizador
     */
    private VBox createUserDataSection() {
        VBox section = new VBox(5);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5;");
        
        Label sectionLabel = new Label("Dados do utilizador");
        sectionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        Label nameLabel = new Label("Nome completo:");
        nameLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        
        nameTextField = new TextField();
        nameTextField.setPromptText("Ex: João Silva");
        nameTextField.setStyle("-fx-pref-width: 400px; -fx-padding: 8;");
        
        Label descriptionLabel = new Label("Descrição do problema:");
        descriptionLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        
        descriptionTextArea = new TextArea();
        descriptionTextArea.setPromptText("Descreva detalhadamente o problema técnico...");
        descriptionTextArea.setPrefRowCount(5);
        descriptionTextArea.setPrefWidth(400);
        descriptionTextArea.setWrapText(true);
        descriptionTextArea.setStyle("-fx-padding: 8;");
        
        section.getChildren().addAll(sectionLabel, nameLabel, nameTextField, descriptionLabel, descriptionTextArea);
        return section;
    }
    
    /**
     * Cria a secção de botões (Nível 3)
     */
    private HBox createButtonSection() {
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
        
        Button submitButton = new Button("Registar Pedido");
        submitButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8 20;");
        submitButton.setOnAction(e -> submitRequest());
        
        Button clearButton = new Button("Clear");
        clearButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8 20;");
        clearButton.setOnAction(e -> clearForm());
        
        buttonBox.getChildren().addAll(submitButton, clearButton);
        return buttonBox;
    }
    
    /**
     * Cria a MenuBar (Nível 4)
     */
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        
        // Menu Ficheiro
        Menu fileMenu = new Menu("Ficheiro");
        
        MenuItem newRequestItem = new MenuItem("Novo Pedido");
        newRequestItem.setAccelerator(new javafx.scene.input.KeyCodeCombination(javafx.scene.input.KeyCode.N, 
            javafx.scene.input.KeyCombination.CONTROL_DOWN));
        newRequestItem.setOnAction(e -> clearForm());
        
        SeparatorMenuItem separator = new SeparatorMenuItem();
        
        MenuItem exitItem = new MenuItem("Sair");
        exitItem.setAccelerator(new javafx.scene.input.KeyCodeCombination(javafx.scene.input.KeyCode.Q, 
            javafx.scene.input.KeyCombination.CONTROL_DOWN));
        exitItem.setOnAction(e -> System.exit(0));
        
        fileMenu.getItems().addAll(newRequestItem, separator, exitItem);
        
        // Menu Ajuda
        Menu helpMenu = new Menu("Ajuda");
        
        MenuItem aboutItem = new MenuItem("Sobre");
        aboutItem.setAccelerator(new javafx.scene.input.KeyCodeCombination(javafx.scene.input.KeyCode.F1));
        aboutItem.setOnAction(e -> showAboutDialog());
        
        helpMenu.getItems().add(aboutItem);
        
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }
    
    /**
     * Adiciona um novo equipamento à lista (Nível 5)
     */
    private void addNewEquipment() {
        String newEquipmentName = otherEquipmentTextField.getText().trim();
        
        if (newEquipmentName.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Aviso", "Por favor, insira o nome do equipamento.");
            return;
        }
        
        // Verificar se o equipamento já existe
        boolean exists = equipments.stream().anyMatch(e -> e.getName().equalsIgnoreCase(newEquipmentName));
        if (exists) {
            showAlert(Alert.AlertType.WARNING, "Aviso", "Este equipamento já existe na lista.");
            return;
        }
        
        // Criar novo equipamento
        Equipment newEquipment = new Equipment(newEquipmentName, "Other");
        equipments.add(equipmentComboBox.getItems().size() - 1, newEquipment); // Adicionar antes do "Other Equipment"
        equipmentComboBox.getItems().add(equipmentComboBox.getItems().size() - 1, newEquipment);
        
        // Limpar e esconder o campo
        otherEquipmentTextField.clear();
        otherEquipmentTextField.setVisible(false);
        otherEquipmentTextField.setManaged(false);
        addEquipmentButton.setVisible(false);
        addEquipmentButton.setManaged(false);
        
        // Selecionar o novo equipamento
        equipmentComboBox.setValue(newEquipment);
        
        // Mostrar confirmação
        showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Equipamento '" + newEquipmentName + "' adicionado com sucesso!");
    }
    
    /**
     * Submete o pedido e cria um objeto Request (Nível 3)
     */
    private void submitRequest() {
        // Recolher dados
        String userType = userTypeComboBox.getValue();
        String name = nameTextField.getText().trim();
        Equipment selectedEquipment = equipmentComboBox.getValue();
        String description = descriptionTextArea.getText().trim();
        
        // Validação
        if (name.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, insira o nome completo.");
            return;
        }
        
        if (description.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, insira a descrição do problema.");
            return;
        }
        
        if (selectedEquipment == null || selectedEquipment.getName().equals("Other Equipment")) {
            showAlert(Alert.AlertType.WARNING, "Equipamento inválido", "Por favor, selecione um equipamento válido.");
            return;
        }
        
        // Criar objeto Request
        Request request = new Request(userType, name, selectedEquipment, description);
        
        // Apresentar na consola
        System.out.println("=== NOVO PEDIDO REGISTADO ===");
        System.out.println(request.toString());
        System.out.println("=============================");
        
        // Mostrar diálogo de confirmação
        Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
        confirmationAlert.setTitle("Pedido Registado");
        confirmationAlert.setHeaderText("Pedido de apoio técnico registado com sucesso!");
        confirmationAlert.setContentText(request.toString());
        confirmationAlert.showAndWait();
    }
    
    /**
     * Limpa todos os campos do formulário
     */
    private void clearForm() {
        userTypeComboBox.setValue("Estudante");
        equipmentComboBox.setValue(equipments.get(0));
        nameTextField.clear();
        descriptionTextArea.clear();
        otherEquipmentTextField.clear();
        otherEquipmentTextField.setVisible(false);
        otherEquipmentTextField.setManaged(false);
        addEquipmentButton.setVisible(false);
        addEquipmentButton.setManaged(false);
    }
    
    /**
     * Mostra o diálogo "Sobre" (Nível 4)
     */
    private void showAboutDialog() {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAlert.setTitle("Ajuda - Sobre a Aplicação");
        aboutAlert.setHeaderText("Gestão de Pedidos de Apoio Técnico");
        aboutAlert.setContentText(
            "Versão: 1.0\n\n" +
            "Desenvolvido para: Laboratório #09 - POO\n" +
            "Data: 2024\n\n" +
            "Funcionalidades:\n" +
            "• Registar pedidos de apoio técnico\n" +
            "• Adicionar novos equipamentos\n" +
            "• Menu com atalhos de teclado\n\n" +
            "© Instituto Politécnico de Setúbal"
        );
        aboutAlert.showAndWait();
    }
    
    /**
     * Método auxiliar para mostrar alertas
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}