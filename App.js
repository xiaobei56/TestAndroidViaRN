import React, {Component} from 'react';

import {Platform, StyleSheet, Text, View, ToastAndroid, DeviceEventEmitter, Button,NativeModules} from 'react-native';

export default class App extends Component<Props> {


    constructor(props) {
        super(props);
        this.state = {
            info: "这是要变的数据"
        }
    }

    componentWillMount() {
        this.rnFunctionListener = DeviceEventEmitter.addListener('rnFunction', e => {
         this.setState({
                        info: e.data
                    })
        });
    }
    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>{this.state.info}</Text>
                <Button
                    style={styles.welcome}
                    title="调原生组件"
                    onPress={() => this.btnClick()}
                />
            </View>
        );
    }

    btnClick() {
        NativeModules.NativeCallRNModule.doLogin("张飞", "1111").then(result => {
            this.setState({
                info: "看弹窗，是原生的Toast组件"
            })
        })


    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
