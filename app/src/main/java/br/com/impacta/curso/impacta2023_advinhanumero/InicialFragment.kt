package br.com.impacta.curso.impacta2023_advinhanumero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.impacta.curso.impacta2023_advinhanumero.databinding.FragmentInicialBinding
import kotlin.random.Random


class InicialFragment : Fragment() {

    private var _binding: FragmentInicialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInicialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numeroSorteado = Random.nextInt(0, 10)
        Log.d("IMPACTA2", "numeroSorteado: $numeroSorteado")

        binding.button.setOnClickListener {
            try {
                val inputUsuario = binding.editTextNumber.text.toString().toInt()

                val acao = when {
                    inputUsuario > numeroSorteado -> R.id.action_inicialFragment_to_chuteMaiorFragment
                    inputUsuario < numeroSorteado -> R.id.action_inicialFragment_to_chuteMenorFragment
                    else -> R.id.action_inicialFragment_to_parabensFragment
                }

                findNavController().navigate(acao)
            } catch (e: java.lang.NumberFormatException) {
                binding.editTextNumber.error = getString(R.string.nao_digitou_numero)
            }
        }
    }


}