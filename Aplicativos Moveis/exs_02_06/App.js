import React, { useState } from 'react';
import {
  View,
  Text,
  TextInput,
  Button,
  ScrollView,
  StyleSheet,
  Alert
} from 'react-native';
import Checkbox from 'expo-checkbox';
import { RadioButton, Provider as PaperProvider } from 'react-native-paper';

export default function App() {
  // --- ESTADOS DO FORMULÁRIO ---
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [telefone, setTelefone] = useState('');
  const [endereco, setEndereco] = useState('');
  
  // Estado para o Radio Button (inicia com Masculino por padrão)
  const [sexo, setSexo] = useState('Masculino');
  
  // Estados para os Checkboxes
  const [aceitouTermos, setAceitouTermos] = useState(false);
  const [receberEmail, setReceberEmail] = useState(false);

  // Estados de controle da lista
  const [contatos, setContatos] = useState([]);
  const [proximoId, setProximoId] = useState(1);

  // --- FUNÇÃO PARA SALVAR CONTATO ---
  function adicionarContato() {
    // Validação básica para garantir que campos de texto não estejam vazios
    if (nome.trim() === '' || cpf.trim() === '' || telefone.trim() === '' || endereco.trim() === '') {
      Alert.alert('Atenção', 'Preencha todos os campos de texto!');
      return;
    }

    // Validação do Checkbox obrigatório (Termos de Uso)
    if (!aceitouTermos) {
      Alert.alert('Atenção', 'Você deve aceitar os termos para continuar.');
      return;
    }

    // Criação do novo objeto de contato com todos os campos
    const novo = { 
      id: proximoId, 
      nome, 
      cpf, 
      telefone, 
      endereco, 
      sexo, 
      aceitouTermos, 
      receberEmail 
    };

    // Atualiza a lista e o ID
    setContatos(contatos.concat(novo));
    setProximoId(proximoId + 1);

    // Limpa os campos após salvar
    setNome('');
    setCpf('');
    setTelefone('');
    setEndereco('');
    setSexo('Masculino');
    setAceitouTermos(false);
    setReceberEmail(false);
  }

  return (
    // O PaperProvider é necessário para os componentes do react-native-paper funcionarem corretamente
    <PaperProvider>
      <View style={styles.container}>
        <Text style={styles.titulo}>Cadastro de Contatos</Text>

        <ScrollView style={styles.formContainer}>
          {/* EXERCÍCIO 1: Campos adicionais de texto */}
          <TextInput style={styles.input} placeholder="Nome" value={nome} onChangeText={setNome} />
          <TextInput style={styles.input} placeholder="CPF" value={cpf} onChangeText={setCpf} keyboardType="numeric" />
          <TextInput style={styles.input} placeholder="Telefone" value={telefone} onChangeText={setTelefone} keyboardType="phone-pad" />
          <TextInput style={styles.input} placeholder="Endereço" value={endereco} onChangeText={setEndereco} />

          {/* EXERCÍCIO 2: Radio Button para Sexo */}
          <Text style={styles.label}>Sexo:</Text>
          <RadioButton.Group onValueChange={newValue => setSexo(newValue)} value={sexo}>
            <View style={styles.radioGroup}>
              <View style={styles.radioItem}>
                <Text>Masculino</Text>
                <RadioButton value="Masculino" />
              </View>
              <View style={styles.radioItem}>
                <Text>Feminino</Text>
                <RadioButton value="Feminino" />
              </View>
            </View>
          </RadioButton.Group>

          {/* EXERCÍCIO 2: Checkbox para Termos e E-mail */}
          <View style={styles.checkboxContainer}>
            <Checkbox
              style={styles.checkbox}
              value={aceitouTermos}
              onValueChange={setAceitouTermos}
              color={aceitouTermos ? '#4630EB' : undefined}
            />
            <Text>Aceitar os Termos (obrigatório)</Text>
          </View>

          <View style={styles.checkboxContainer}>
            <Checkbox
              style={styles.checkbox}
              value={receberEmail}
              onValueChange={setReceberEmail}
              color={receberEmail ? '#4630EB' : undefined}
            />
            <Text>Quero receber informações por e-mail</Text>
          </View>

          <View style={styles.buttonContainer}>
            <Button title="Salvar" onPress={adicionarContato} />
          </View>
        </ScrollView>

        <Text style={styles.tituloLista}>Contatos Salvos</Text>
        
        {/* EXIBIÇÃO DA LISTA COM TODOS OS CAMPOS */}
        <ScrollView style={styles.lista}>
          {contatos.map(contato => (
            <View key={contato.id} style={styles.itemCard}>
              <Text style={styles.itemNome}>{contato.id} - {contato.nome}</Text>
              <Text>CPF: {contato.cpf}</Text>
              <Text>Telefone: {contato.telefone}</Text>
              <Text>Endereço: {contato.endereco}</Text>
              <Text>Sexo: {contato.sexo}</Text>
              <Text style={styles.itemDestaque}>
                {contato.aceitouTermos ? "Aceitou os termos" : "Não aceitou os termos"}
              </Text>
              <Text style={styles.itemDestaque}>
                {contato.receberEmail ? "Quer receber e-mail" : "Não quer receber e-mail"}
              </Text>
            </View>
          ))}
        </ScrollView>
      </View>
    </PaperProvider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    marginTop: 40,
    backgroundColor: '#f5f5f5'
  },
  titulo: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 15,
    textAlign: 'center'
  },
  formContainer: {
    flex: 1,
    marginBottom: 10
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 10,
    borderRadius: 5,
    backgroundColor: '#fff'
  },
  label: {
    fontSize: 16,
    fontWeight: 'bold',
    marginTop: 5,
    marginBottom: 5
  },
  radioGroup: {
    flexDirection: 'row',
    justifyContent: 'flex-start',
    marginBottom: 15
  },
  radioItem: {
    flexDirection: 'row',
    alignItems: 'center',
    marginRight: 20
  },
  checkboxContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 15
  },
  checkbox: {
    marginRight: 10
  },
  buttonContainer: {
    marginTop: 10,
    marginBottom: 20
  },
  tituloLista: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
    borderTopWidth: 1,
    borderColor: '#ccc',
    paddingTop: 10
  },
  lista: {
    flex: 1
  },
  itemCard: {
    backgroundColor: '#fff',
    padding: 15,
    marginBottom: 10,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#ddd',
    elevation: 2 // Sombra no Android
  },
  itemNome: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 5
  },
  itemDestaque: {
    fontStyle: 'italic',
    color: '#555',
    marginTop: 2
  }
});